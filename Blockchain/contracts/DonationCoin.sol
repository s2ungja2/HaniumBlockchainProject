pragma solidity ^0.4.23;

import "../node_modules/openzeppelin-solidity/contracts/token/ERC20/StandardToken.sol";

contract DonationCoin is StandardToken {
  string public name     = "DonationCoin";
  string public symbol   = "DNTC"
  uint8 public decimals  = 18;

  uint256 public constant INITIAL_SUPPLY = 1000000000;

  function DonationCoin() public {
    totalSupply_ = INITIAL_SUPPLY * (10 ** uint256(decimals));
    balances[msg.sender] = totalSupply_;
  }
}
