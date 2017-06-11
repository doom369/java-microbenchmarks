```
Benchmark                              (strParams)   Mode  Cnt       Score      Error  Units
ParseDouble.parseDouble                             thrpt   40     735.459 ±   15.955  ops/s
ParseDouble.parseDouble                    123.123  thrpt   40   22889.555 ±  334.458  ops/s
ParseDouble.parseDouble                        123  thrpt   40   29399.797 ±  743.170  ops/s
ParseDouble.parseDouble                  123.123 F  thrpt   40     718.028 ±   11.019  ops/s
ParseDouble.parseDouble                  p 123.123  thrpt   40     727.713 ±   10.969  ops/s
ParseDouble.parseDoubleAlternative                  thrpt   40  225276.734 ± 4440.722  ops/s
ParseDouble.parseDoubleAlternative         123.123  thrpt   40   48331.828 ±  683.468  ops/s
ParseDouble.parseDoubleAlternative             123  thrpt   40   70308.628 ± 1001.203  ops/s
ParseDouble.parseDoubleAlternative       123.123 F  thrpt   40   46639.082 ±  452.606  ops/s
ParseDouble.parseDoubleAlternative       p 123.123  thrpt   40  162638.626 ±  422.244  ops/s
ParseDouble.parseDoubleWithConditions               thrpt   40     876.182 ±   18.215  ops/s
ParseDouble.parseDoubleWithConditions      123.123  thrpt   40   22393.140 ±  389.346  ops/s
ParseDouble.parseDoubleWithConditions          123  thrpt   40   28561.857 ±  436.017  ops/s
ParseDouble.parseDoubleWithConditions    123.123 F  thrpt   40     713.820 ±   21.120  ops/s
ParseDouble.parseDoubleWithConditions    p 123.123  thrpt   40  227432.731 ± 1460.840  ops/s
```