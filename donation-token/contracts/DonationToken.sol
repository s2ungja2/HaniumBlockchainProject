pragma solidity ^0.4.23;

import './StandardToken.sol';

contract DonationToken is StandardToken{
  string public name      = "DonationToken";
  string public symbol    = "DONAT";
  uint8 public decimals   = 18;

  uint256 public constant INITIAL_SUPPLY = 1000000000;

  function DonationToken() public {
    totalSupply_ = INITIAL_SUPPLY * ( 10 ** uint256(decimals));
    balances[msg.sender] = totalSupply_;
  }
}
