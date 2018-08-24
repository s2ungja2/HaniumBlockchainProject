pragma solidity ^0.4.24;

import "./StandardToken.sol";

/// @title 기부토큰 컨트랙
/// @author 이승재, 송현수, 남윤서

/// @TODO
/// 1. viewRank 구현
/// 2. TX Data를 solidity에 담는법
/// 3. solidity와 db 연동하는 api가 있는지

contract DonationToken is StandardToken{
  uint public INITIAL_SUPPLY = 21000000;
  string public name = "DonationToken";
  string public symbol = "DNTT";
  uint8 public decimals = 8;

  mapping (address => uint256) public transfercount;
  mapping (address => uint16) public rank;
  mapping (address => uint8) public info;

  constructor() public {
    totalSupply_ = INITIAL_SUPPLY * ( 10 ** uint256(decimals));
    balances[msg.sender] = INITIAL_SUPPLY;
    rank[msg.sender] = 0;
    info[msg.sender] = 0;
  }

  function setUser1(address _who) public {
    require (info[msg.sender] == 0);
    info[_who] = 1;
  }

  function setGov(address _who) public {
    require (info[msg.sender] == 0);
    info[_who] = 2;
  }

  function setUser2(address _who) public {
    require (info[msg.sender] == 0);
    info[_who] = 3;
  }

  function getInfo(address _who) public view returns (uint8) {
    return info[_who];
  }

  function getRank(address _who) public view returns (uint16) {
    return rank[_who];
  }

  function getTransfercount(address _who) public view returns (uint256) {
    return transfercount[_who];
  }

  function viewRank() public view returns (address) {

  }

  function transfer(address _to, uint256 _value) public returns (bool) {
    require (info[msg.sender] == 0 || (info[msg.sender] == 1 && info[_to] == 2) || (info[msg.sender] == 2 && info[_to] == 3));
    super.transfer(_to, _value);
    balances[msg.sender] = balances[msg.sender].add(_value.div(100));
    transfercount[msg.sender] = transfercount[msg.sender].add(1);
  }

  function transferFrom(address _from, address _to, uint256 _value) public returns (bool) {
    require (info[msg.sender] == 0 || (info[msg.sender] == info[_from]));
    require ((info[_from] == 1 && info[_to] == 2) || (info[_from] == 2 && info[_to] == 3));
    super.transferFrom(_from, _to, _value);
    balances[_from] = balances[_from].add(_value.div(100));
    transfercount[_from] = transfercount[_from].add(1);
  }

  function allowance(address _owner, address _spender) public view returns (uint256) {
    super.allowance(_owner, _spender);
  }

  function approve(address _spender, uint256 _value) public returns (bool) {
    super.approve(_spender, _value);
  }
}
