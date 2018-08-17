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
    networks :{
        development: {
            host: "127.0.0.1",
            port: 8545,
            network_id: "*",
        }
    }
};

// module.exports = {
//     // See <http://truffleframework.com/docs/advanced/configuration>
//     // to customize your Truffle configuration!
//     networks :{
//         development: {
//             host: "14.63.194.247",
//             port: 8545,
//             network_id: "74127412",
//             from: "0x99de12f3150b393c89ddccb384dd9cf8fa8414c0"
//         }
//     }
// };
