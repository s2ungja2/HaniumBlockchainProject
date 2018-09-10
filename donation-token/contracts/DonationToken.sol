pragma solidity ^0.4.24;

import "./StandardToken.sol";

/// @title 기부토큰 스마트컨트랙
/// @author 이승재, 송현수, 남윤서
contract DonationToken is StandardToken{
  uint public INITIAL_SUPPLY = 21000000;
  string public name = "DonationToken";
  string public symbol = "DNTT";
  address public owner;

  mapping (address => uint256) public donatecount;
  mapping (address => uint8) public info;

  constructor() public {
    totalSupply_ = INITIAL_SUPPLY;
    balances[msg.sender] = INITIAL_SUPPLY;
    info[msg.sender] = 0;
    owner = msg.sender;
  }

  /// @dev 토큰 발행자만 실행시킬 수 있는 함수의 조건을 주기위한 modifier
  modifier onlyOwner {
    require(msg.sender == owner);
    _;
  }

  /// @dev 사용자의 info를 기부자로 셋팅한다. owner만 수행가능
  /// @param _who info를 바꾸고자 하는 사용자의 주소
  function setUser1(address _who) public onlyOwner {
    info[_who] = 1;
  }

  /// @dev 사용자의 info를 기부단체로 셋팅한다. owner만 수행가능
  /// @param _who info를 바꾸고자 하는 사용자의 주소
  function setGov(address _who) public onlyOwner {
    info[_who] = 2;
  }

  /// @dev 사용자의 info를 피기부자로 셋팅한다. owner만 수행가능
  /// @param _who info를 바꾸고자 하는 사용자의 주소
  function setUser2(address _who) public onlyOwner {
    info[_who] = 3;
  }

  /// @dev 사용자의 info를 가져온다.
  /// @param _who info를 알고자 하는 사용자의 주소
  /// @return info[_who] 사용자의 정보
  function getInfo(address _who) public view returns (uint8) {
    return info[_who];
  }

  /// @dev 사용자의 기부횟수를 가져온다.
  /// @param _who 기부횟수를 알고자 하는 사용자의 주소
  /// @return donatecount[_who] 사용자의 기부횟수
  function getDonatecount(address _who) public view returns (uint256) {
    return donatecount[_who];
  }

  /// @dev 호출자의 지갑에서 다른 지갑으로 기부한다.
  /// @param _to 토큰을 받는 사용자의 지갑주소
  /// @param _value 보내고자 하는 토큰의 양
  /// @return 성공시 true, 실패시 error
  function donate(address _to, uint256 _value) public returns (bool) {
    require (msg.sender == owner || (info[msg.sender] == 1 && info[_to] == 2) || (info[msg.sender] == 2 && info[_to] == 3));
    super.transfer(_to, _value);
    balances[msg.sender] = balances[msg.sender].add(_value.div(100));
    donatecount[msg.sender] = donatecount[msg.sender].add(1);
  }
  /// @dev _from의 지갑에서 _to로 토큰을 기부한다.
  /// @param _from 토큰이 빠져나가는 지갑주소
  /// @param _to 토큰을 받는 사용자의 지갑주소
  /// @param _value 보내고자 하는 토큰의 양
  /// @return 성공시 true, 실패시 error
  function donateFrom(address _from, address _to, uint256 _value) public returns (bool) {
    require (info[msg.sender] == info[_from]);
    require ((info[_from] == 1 && info[_to] == 2) || (info[_from] == 2 && info[_to] == 3));
    super.transferFrom(_from, _to, _value);
    balances[_from] = balances[_from].add(_value.div(100));
    donatecount[_from] = donatecount[_from].add(1);
  }

  /// @dev openzeppelin의 transfer함수. StandardToken.sol에 정의되어 있다.
  function transfer(address _to, uint256 _value) public returns (bool) {
    super.transfer(_to, _value);
  }

  /// @dev openzeppelin의 transferFrom함수. StandardToken.sol에 정의되어 있다.
  function transferFrom(address _from, address _to, uint256 _value) public returns (bool) {
    super.transferFrom(_from, _to, _value);
  }

  /// @dev openzeppelin의 allowance함수. StandardToken.sol에 정의되어 있다.
  function allowance(address _owner, address _spender) public view returns (uint256) {
    super.allowance(_owner, _spender);
  }

  /// @dev openzeppelin의 approve함수. StandardToken.sol에 정의되어 있다.
  function approve(address _spender, uint256 _value) public returns (bool) {
    super.approve(_spender, _value);
  }
}
