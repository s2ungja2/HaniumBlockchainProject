pragma solidity ^0.4.23;

import '../node_modules/zeppelin-solidity/contracts/token/ERC20/StandardToken.sol';

contract DonationToken is StandardToken{
  uint public INITIAL_SUPPLY = 21000000;
  string public name = 'DonationToken';
  string public symbol = 'DNTT';
  uint8 public decimals = 8;
  address owner;

  function DonationToken() public {
    totalSupply_ = INITIAL_SUPPLY * ( 10 ** uint256(decimals));
    balances[msg.sender] = INITIAL_SUPPLY;
    owner = msg.sender;
  }

  function transfer(address to, uint256 value) public returns (bool) {
    super.transfer(to, value);
    balances[msg.sender] = balances[msg.sender].add(value.div(100));
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
}
