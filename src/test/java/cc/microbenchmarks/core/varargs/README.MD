```
Benchmark                                              Mode  Cnt        Score        Error   Units
VarargsNew5.noVarArgs                                 thrpt   20  7633026.221 ± 354065.490   ops/s
VarargsNew5.noVarArgs:·gc.alloc.rate                  thrpt   20        0.001 ±      0.002  MB/sec
VarargsNew5.noVarArgs:·gc.alloc.rate.norm             thrpt   20       ≈ 10⁻⁴                 B/op
VarargsNew5.noVarArgs:·gc.count                       thrpt   20          ≈ 0               counts
VarargsNew5.varArgs                                   thrpt   20  3916635.694 ± 175434.392   ops/s
VarargsNew5.varArgs:·gc.alloc.rate                    thrpt   20       79.668 ±      3.568  MB/sec
VarargsNew5.varArgs:·gc.alloc.rate.norm               thrpt   20       32.000 ±      0.001    B/op
VarargsNew5.varArgs:·gc.churn.PS_Eden_Space           thrpt   20       80.755 ±     23.053  MB/sec
VarargsNew5.varArgs:·gc.churn.PS_Eden_Space.norm      thrpt   20       32.638 ±      9.686    B/op
VarargsNew5.varArgs:·gc.churn.PS_Survivor_Space       thrpt   20        0.024 ±      0.023  MB/sec
VarargsNew5.varArgs:·gc.churn.PS_Survivor_Space.norm  thrpt   20        0.010 ±      0.009    B/op
VarargsNew5.varArgs:·gc.count                         thrpt   20       28.000               counts
VarargsNew5.varArgs:·gc.time                          thrpt   20       27.000                   ms
```
