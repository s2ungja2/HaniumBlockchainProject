pragma solidity ^0.4.24;

import "./StandardToken.sol";

/// @title 기부토큰 컨트랙
/// @author 이승재, 송현수, 남윤서

contract DonationToken is StandardToken{
  uint public INITIAL_SUPPLY = 21000000;
  string public name = "DonationToken";
  string public symbol = "DNTT";
  address public owner;

  mapping (address => uint256) public transfercount;
  mapping (address => uint8) public info;

  constructor() public {
    totalSupply_ = INITIAL_SUPPLY;
    balances[msg.sender] = INITIAL_SUPPLY;
    info[msg.sender] = 0;
    owner = msg.sender;
  }

  modifier onlyOwner {
    require(msg.sender == owner);
    _;
  }

  function setUser1(address _who) public onlyOwner {  // 기부자
    info[_who] = 1;
  }

  function setGov(address _who) public onlyOwner {    // 기부단체
    info[_who] = 2;
  }

  function setUser2(address _who) public onlyOwner {  // 기부받는사람
    info[_who] = 3;
  }

  function getInfo(address _who) public view returns (uint8) {
    return info[_who];
  }

  function getTransfercount(address _who) public view returns (uint256) {
    return transfercount[_who];
  }

  function donate(address _to, uint256 _value) public returns (bool) {
    require (msg.sender == owner || (info[msg.sender] == 1 && info[_to] == 2) || (info[msg.sender] == 2 && info[_to] == 3));
    super.transfer(_to, _value);
    balances[msg.sender] = balances[msg.sender].add(_value.div(100));
    transfercount[msg.sender] = transfercount[msg.sender].add(1);
  }

  function donateFrom(address _from, address _to, uint256 _value) public returns (bool) {
    require (info[msg.sender] == info[_from]);
    require ((info[_from] == 1 && info[_to] == 2) || (info[_from] == 2 && info[_to] == 3));
    super.transferFrom(_from, _to, _value);
    balances[_from] = balances[_from].add(_value.div(100));
    transfercount[_from] = transfercount[_from].add(1);
  }

  function transfer(address _to, uint256 _value) public returns (bool) {
    super.transfer(_to, _value);
  }

  function transferFrom(address _from, address _to, uint256 _value) public returns (bool) {
    super.transferFrom(_from, _to, _value);
  }

  function allowance(address _owner, address _spender) public view returns (uint256) {
    super.allowance(_owner, _spender);
  }

  function approve(address _spender, uint256 _value) public returns (bool) {
    super.approve(_spender, _value);
  }
}
