package cn.happymaya.imayamall.constant;

/**
 * <h1>授权需要使用的一些常量信息</h1>
 * */
public final class AuthorityConstant {

    /** RSA 私钥, 除了授权中心以外, 不暴露给任何客户端 */
    public static final String PRIVATE_KEY = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCJIVS" +
            "ZzWiLdidACYEsb/Qr6WDDPj/P+WHO1nIRrV77mKHDDE+3o2msIrU2FNmB+1nqcnOKqjPOUbkIDxUhwEWXgqlntdP" +
            "qGSSPBbH0Zqwtlue5AT4qJu/8lXIObLMcTOfuZHbdqc9RE9bGHSUmE9+ZkoTOZFS72jMquqi4SHSpZM0khvOn4zC" +
            "di0CdX3KDbbQZOzIdz/jPCcfFvALb5DAQm8FxQEZ/FKux4aih+JpTjlp9AYDD2pzdaReYTGK7ulnmSDj1BjDvSqG" +
            "EtH6ZmRRrQez7YaerfItgviGwULr45AYnuk6LkFDrz2pV9ga8SB5l2g7h+9U3frIRVIDZw7oTAgMBAAECggEAYl7" +
            "TlqVgerLegzSOQndpPFrlPAoasrGd9UemeoHZIjkiyY26XezO8FnRjqM0SOcrYGCL/AwOr9G2H07ahOStx3tG1Qv" +
            "9ofA5ZpPaTY2ds/KN9gwrMQfPnm0CbdCSSBnvQvc0wdx/yRSnPGVJ8d/NxhfyRzB4DG4ByIQwZkorzhtgsYZ2LqC" +
            "7b5QAXAEsGanldW0mHdDA+xfDxJELYaIiEowqibhaTzGXEFUXBDjwSqdcSwQSw+7w0O4wbNgt3WQC04kzdnoSOcQ" +
            "V4YoAjVrEoIe2hZsGBOYwN7VKYMmeWPYh58cCiuGvdtGD6R7KTR4bGHsKs3uw/swEVIR8fNooiQKBgQDMOW+u9ZY" +
            "7vPAH2N+Ab0s7aS5yREm1SjxfUAFPa1yoAPfLblIfWBOJqUyrPA6adZqJUfuyB84iGkU4j4N7prsPm9fLyRl38Qo" +
            "cvb0Cj9lNB4riGk2u5YZvhtgA8RznvGVPT0xO9jn/+SAfdVa7plyBArc7gqMpY7BvjNal2RNRTQKBgQCr5VnHY4H" +
            "u/UM4dm12tJBtgbkqoHgjxgLhtWheRXcVNH+YxxCyoXx07YM253w682R4QrPKpoqZfEDOPaZhizRb4xOHk93+pRm" +
            "PN8h8Ub1fRKzIg/zTadpae80k93EI+Qv+SzIBd8++m7I2cBBj0vqjIPxahwYu4z+elA+MyjuI3wKBgD6mjB2HV6x" +
            "B3Pz7Si1zdwflz4rcaiREftrah1xe2lDr4xi0YlsdQPklR9DsHqrB00O3M9i8zj7mAkBEvphLYO176KqqqbaC6pB" +
            "AoOBNUuNvoeqVGSnDXgeOvWskjLKGuCmpcQZ0QPzG51TfQVlVwuEM/Tsza2yCGZlPAnZkbqmtAoGAVF92+c9174C" +
            "Qhh5bDHEEkzuhT7MERUrkDzWjzOH72YSzPKI5J/TrydjrFv/4klb1cbIL3eRxE3VRuem4yRgy0wdahqmlxV/0c7/" +
            "FwH++nAxxYtqmNn82lkM+Jm7uJKFZqa/vE5ljdwOlLeNDqDvemkOOmkC8YDda+tNh7pE1N7ECgYAfgWHCYfDSfyp" +
            "cz2xY6kTzP1YrSegLYdNIL7ygl32apCUlbCLF3USlkFRdRKfQspKMS7SVjgXhj1udM6vBRlwH2pXZEfXxj+MzdvJ" +
            "mKK0X2ebjTD61X8FLdZiJkJrtbh8r8m1lbIrluBe8SMqOwGSuQhl+sQJ2qouPFUO6s3aWNA==";

    /** RSA 公钥 */
    public static final String PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAiSFUmc1oi3Yn" +
            "QAmBLG/0K+lgwz4/z/lhztZyEa1e+5ihwwxPt6NprCK1NhTZgftZ6nJziqozzlG5CA8VIcBFl4KpZ7XT6hkkjwWx" +
            "9GasLZbnuQE+Kibv/JVyDmyzHEzn7mR23anPURPWxh0lJhPfmZKEzmRUu9ozKrqouEh0qWTNJIbzp+MwnYtAnV9y" +
            "g220GTsyHc/4zwnHxbwC2+QwEJvBcUBGfxSrseGoofiaU45afQGAw9qc3WkXmExiu7pZ5kg49QYw70qhhLR+mZkU" +
            "a0Hs+2Gnq3yLYL4hsFC6+OQGJ7pOi5BQ689qVfYGvEgeZdoO4fvVN36yEVSA2cO6EwIDAQAB";

    /** 默认的 Token 超时时间, 一天 */
    public static final Integer DEFAULT_EXPIRE_DAY = 1;
}
