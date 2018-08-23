pragma solidity ^0.4.24;

import "./StandardToken.sol";

contract DonationToken is StandardToken{
  uint public INITIAL_SUPPLY = 21000000;
  string public name = "DonationToken";
  string public symbol = "DNTT";
  uint8 public decimals = 8;
  mapping (address => uint256) public rank;

  function DonationToken() public {
    totalSupply_ = INITIAL_SUPPLY * ( 10 ** uint256(decimals));
    balances[msg.sender] = INITIAL_SUPPLY;
  }

  function transfer(address to, uint256 value) public returns (bool) {
    super.transfer(to, value);
    balances[msg.sender] = balances[msg.sender].add(value.div(100));
    rank[msg.sender] = rank[msg.sender].add(1);
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

  function rankOf(address who) public view returns (uint256){
    return rank[who];
  }

  function getRank() public view returns (address) {
    
  }
}
