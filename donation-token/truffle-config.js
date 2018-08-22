/*
 * NB: since truffle-hdwallet-provider 0.0.5 you must wrap HDWallet providers in a 
 * function when declaring them. Failure to do so will cause commands to hang. ex:
 * ```
 * mainnet: {
 *     provider: function() { 
 *       return new HDWalletProvider(mnemonic, 'https://mainnet.infura.io/<infura-key>') 
 *     },
 *     network_id: '1',
 *     gas: 4500000,
 *     gasPrice: 10000000000,
 *   },
 */

module.exports = {
  // See <http://truffleframework.com/docs/advanced/configuration>
  // to customize your Truffle configuration!
<<<<<<< HEAD:donation-token/truffle-config.js
  networks :{
      local_ganache: {
          host: "127.0.0.1",
          port: 9545,
          network_id: "*",
      }
=======

  network: {
    development: {
      host: "127.0.0.1",
      port: 7545,
      network_id: "*"
    }
>>>>>>> 66c3984efa49b4ae53134956b5560aa88b44567f:Blockchain/truffle.js
  }
};
