pragma solidity ^0.4.24;

import "./StandardToken.sol";

/// @title 기부토큰 컨트랙
/// @author 이승재, 송현수, 남윤서
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

  function setUser1(address who) public {
    require (info[msg.sender] == 0);
    info[who] = 1;
  }

  function setGov(address who) public {
    require (info[msg.sender] == 0);
    info[who] = 2;
  }

  function setUser2(address who) public {
    require (info[msg.sender] == 0);
    info[who] = 3;
  }

  function getInfo(address who) public view returns (uint8) {
    return info[who];
  }

  function getRank(address who) public view returns (uint16) {
    return rank[who];
  }

  function getTransfercount(address who) public view returns (uint256) {
    return transfercount[who];
  }

  function viewRank() public view returns (address) {

  }

  function transfer(address to, uint256 value) public returns (bool) {
    require (info[msg.sender] == 0 || (info[msg.sender] == 1 && info[to] == 2) || (info[msg.sender] == 2 && info[to] == 3));
    super.transfer(to, value);
    balances[msg.sender] = balances[msg.sender].add(value.div(100));
    transfercount[msg.sender] = transfercount[msg.sender].add(1);
  }

  function allowance(address owner, address spender) public view returns (uint256) {
    super.allowance(owner, spender);
  }

  function transferFrom(address from, address to, uint256 value) public returns (bool) {
    super.transferFrom(from, to, value);
  }

  function approve(address spender, uint256 value) public returns (bool) {
    super.approve(spender, value);
  }

  /// @TODO
  /// 1. viewRank 구현
  /// 2. setUser1(기부자) / setGov(기부단체) / setUser2(기부받는사람) 구현
  /// 3. transfer수정 (User1은 Gov로만, Gov는 User2로만 가능)
  /// 4. info mapping 추가 - 2. 에서 사용할 정보
}
