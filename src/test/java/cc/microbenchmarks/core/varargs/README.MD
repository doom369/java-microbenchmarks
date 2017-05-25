/usr/lib/jvm/java-8-oracle/bin/java -Dfile.encoding=UTF-8 -classpath /home/doom369/IdeaProjects/java-microbenchmarks/target/test-classes:/home/doom369/.m2/repository/com/fasterxml/jackson/core/jackson-databind/2.8.6/jackson-databind-2.8.6.jar:/home/doom369/.m2/repository/com/fasterxml/jackson/core/jackson-annotations/2.8.0/jackson-annotations-2.8.0.jar:/home/doom369/.m2/repository/com/fasterxml/jackson/core/jackson-core/2.8.6/jackson-core-2.8.6.jar:/home/doom369/.m2/repository/org/apache/commons/commons-lang3/3.5/commons-lang3-3.5.jar:/home/doom369/.m2/repository/org/openjdk/jmh/jmh-core/1.18/jmh-core-1.18.jar:/home/doom369/.m2/repository/net/sf/jopt-simple/jopt-simple/4.6/jopt-simple-4.6.jar:/home/doom369/.m2/repository/org/apache/commons/commons-math3/3.2/commons-math3-3.2.jar:/home/doom369/.m2/repository/org/openjdk/jmh/jmh-generator-annprocess/1.18/jmh-generator-annprocess-1.18.jar org.openjdk.jmh.Main cc.microbenchmarks.core.varargs.VarargsNew5.* -prof gc
# JMH 1.18 (released 40 days ago)
# VM version: JDK 1.8.0_121, VM 25.121-b13
# VM invoker: /usr/lib/jvm/java-8-oracle/jre/bin/java
# VM options: -Dfile.encoding=UTF-8
# Warmup: 10 iterations, 1 s each
# Measurement: 20 iterations, 1 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Throughput, ops/time
# Benchmark: cc.microbenchmarks.core.varargs.VarargsNew5.noVarArgs

# Run progress: 0.00% complete, ETA 00:01:00
# Fork: 1 of 1
# Warmup Iteration   1: 7514228.590 ops/s
# Warmup Iteration   2: 8052046.946 ops/s
# Warmup Iteration   3: 7531790.169 ops/s
# Warmup Iteration   4: 7107963.956 ops/s
# Warmup Iteration   5: 7538957.005 ops/s
# Warmup Iteration   6: 7285139.934 ops/s
# Warmup Iteration   7: 7632430.123 ops/s
# Warmup Iteration   8: 7155990.616 ops/s
# Warmup Iteration   9: 7668721.741 ops/s
# Warmup Iteration  10: 7095545.084 ops/s
Iteration   1: 7404882.611 ops/s
                 ·gc.alloc.rate:      ≈ 10⁻⁴ MB/sec
                 ·gc.alloc.rate.norm: ≈ 10⁻⁴ B/op
                 ·gc.count:           ≈ 0 counts

Iteration   2: 6998331.111 ops/s
                 ·gc.alloc.rate:      ≈ 10⁻⁴ MB/sec
                 ·gc.alloc.rate.norm: ≈ 10⁻⁴ B/op
                 ·gc.count:           ≈ 0 counts

Iteration   3: 7703659.401 ops/s
                 ·gc.alloc.rate:      ≈ 10⁻⁴ MB/sec
                 ·gc.alloc.rate.norm: ≈ 10⁻⁴ B/op
                 ·gc.count:           ≈ 0 counts

Iteration   4: 6995479.483 ops/s
                 ·gc.alloc.rate:      ≈ 10⁻⁴ MB/sec
                 ·gc.alloc.rate.norm: ≈ 10⁻⁴ B/op
                 ·gc.count:           ≈ 0 counts

Iteration   5: 7455386.949 ops/s
                 ·gc.alloc.rate:      ≈ 10⁻⁴ MB/sec
                 ·gc.alloc.rate.norm: ≈ 10⁻⁴ B/op
                 ·gc.count:           ≈ 0 counts

Iteration   6: 7142956.809 ops/s
                 ·gc.alloc.rate:      0.008 MB/sec
                 ·gc.alloc.rate.norm: 0.002 B/op
                 ·gc.count:           ≈ 0 counts

Iteration   7: 8058861.156 ops/s
                 ·gc.alloc.rate:      ≈ 10⁻⁴ MB/sec
                 ·gc.alloc.rate.norm: ≈ 10⁻⁴ B/op
                 ·gc.count:           ≈ 0 counts

Iteration   8: 7506274.156 ops/s
                 ·gc.alloc.rate:      ≈ 10⁻⁴ MB/sec
                 ·gc.alloc.rate.norm: ≈ 10⁻⁴ B/op
                 ·gc.count:           ≈ 0 counts

Iteration   9: 8034270.588 ops/s
                 ·gc.alloc.rate:      ≈ 10⁻⁴ MB/sec
                 ·gc.alloc.rate.norm: ≈ 10⁻⁴ B/op
                 ·gc.count:           ≈ 0 counts

Iteration  10: 7796326.566 ops/s
                 ·gc.alloc.rate:      ≈ 10⁻⁴ MB/sec
                 ·gc.alloc.rate.norm: ≈ 10⁻⁴ B/op
                 ·gc.count:           ≈ 0 counts

Iteration  11: 8359017.694 ops/s
                 ·gc.alloc.rate:      ≈ 10⁻⁴ MB/sec
                 ·gc.alloc.rate.norm: ≈ 10⁻⁴ B/op
                 ·gc.count:           ≈ 0 counts

Iteration  12: 7063477.049 ops/s
                 ·gc.alloc.rate:      ≈ 10⁻⁴ MB/sec
                 ·gc.alloc.rate.norm: ≈ 10⁻⁴ B/op
                 ·gc.count:           ≈ 0 counts

Iteration  13: 8406809.872 ops/s
                 ·gc.alloc.rate:      ≈ 10⁻⁴ MB/sec
                 ·gc.alloc.rate.norm: ≈ 10⁻⁴ B/op
                 ·gc.count:           ≈ 0 counts

Iteration  14: 7729368.099 ops/s
                 ·gc.alloc.rate:      ≈ 10⁻⁴ MB/sec
                 ·gc.alloc.rate.norm: ≈ 10⁻⁴ B/op
                 ·gc.count:           ≈ 0 counts

Iteration  15: 7774935.971 ops/s
                 ·gc.alloc.rate:      ≈ 10⁻⁴ MB/sec
                 ·gc.alloc.rate.norm: ≈ 10⁻⁴ B/op
                 ·gc.count:           ≈ 0 counts

Iteration  16: 7513036.692 ops/s
                 ·gc.alloc.rate:      ≈ 10⁻⁴ MB/sec
                 ·gc.alloc.rate.norm: ≈ 10⁻⁴ B/op
                 ·gc.count:           ≈ 0 counts

Iteration  17: 7659236.545 ops/s
                 ·gc.alloc.rate:      ≈ 10⁻⁴ MB/sec
                 ·gc.alloc.rate.norm: ≈ 10⁻⁴ B/op
                 ·gc.count:           ≈ 0 counts

Iteration  18: 7926733.388 ops/s
                 ·gc.alloc.rate:      ≈ 10⁻⁴ MB/sec
                 ·gc.alloc.rate.norm: ≈ 10⁻⁴ B/op
                 ·gc.count:           ≈ 0 counts

Iteration  19: 7716863.721 ops/s
                 ·gc.alloc.rate:      ≈ 10⁻⁴ MB/sec
                 ·gc.alloc.rate.norm: ≈ 10⁻⁴ B/op
                 ·gc.count:           ≈ 0 counts

Iteration  20: 7414616.561 ops/s
                 ·gc.alloc.rate:      ≈ 10⁻⁴ MB/sec
                 ·gc.alloc.rate.norm: ≈ 10⁻⁴ B/op
                 ·gc.count:           ≈ 0 counts



Result "cc.microbenchmarks.core.varargs.VarargsNew5.noVarArgs":
  7633026.221 ±(99.9%) 354065.490 ops/s [Average]
  (min, avg, max) = (6995479.483, 7633026.221, 8406809.872), stdev = 407742.344
  CI (99.9%): [7278960.732, 7987091.711] (assumes normal distribution)

Secondary result "cc.microbenchmarks.core.varargs.VarargsNew5.noVarArgs:·gc.alloc.rate":
  0.001 ±(99.9%) 0.002 MB/sec [Average]
  (min, avg, max) = (≈ 10⁻⁴, 0.001, 0.008), stdev = 0.002
  CI (99.9%): [≈ 0, 0.002] (assumes normal distribution)

Secondary result "cc.microbenchmarks.core.varargs.VarargsNew5.noVarArgs:·gc.alloc.rate.norm":
  ≈ 10⁻⁴ B/op

Secondary result "cc.microbenchmarks.core.varargs.VarargsNew5.noVarArgs:·gc.count":
  ≈ 0 counts


# JMH 1.18 (released 40 days ago)
# VM version: JDK 1.8.0_121, VM 25.121-b13
# VM invoker: /usr/lib/jvm/java-8-oracle/jre/bin/java
# VM options: -Dfile.encoding=UTF-8
# Warmup: 10 iterations, 1 s each
# Measurement: 20 iterations, 1 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Throughput, ops/time
# Benchmark: cc.microbenchmarks.core.varargs.VarargsNew5.varArgs

# Run progress: 50.00% complete, ETA 00:00:45
# Fork: 1 of 1
# Warmup Iteration   1: 4152859.638 ops/s
# Warmup Iteration   2: 3933131.475 ops/s
# Warmup Iteration   3: 4013638.841 ops/s
# Warmup Iteration   4: 4020073.800 ops/s
# Warmup Iteration   5: 3916100.840 ops/s
# Warmup Iteration   6: 4184983.193 ops/s
# Warmup Iteration   7: 4113778.289 ops/s
# Warmup Iteration   8: 4319048.717 ops/s
# Warmup Iteration   9: 3945153.199 ops/s
# Warmup Iteration  10: 3997717.838 ops/s
Iteration   1: 3885340.717 ops/s
                 ·gc.alloc.rate:               79.031 MB/sec
                 ·gc.alloc.rate.norm:          32.000 B/op
                 ·gc.churn.PS_Eden_Space:      73.306 MB/sec
                 ·gc.churn.PS_Eden_Space.norm: 29.682 B/op
                 ·gc.count:                    1.000 counts
                 ·gc.time:                     1.000 ms

Iteration   2: 4266908.446 ops/s
                 ·gc.alloc.rate:                   86.795 MB/sec
                 ·gc.alloc.rate.norm:              32.000 B/op
                 ·gc.churn.PS_Eden_Space:          71.645 MB/sec
                 ·gc.churn.PS_Eden_Space.norm:     26.415 B/op
                 ·gc.churn.PS_Survivor_Space:      0.042 MB/sec
                 ·gc.churn.PS_Survivor_Space.norm: 0.015 B/op
                 ·gc.count:                        1.000 counts
                 ·gc.time:                         ≈ 0 ms

Iteration   3: 4036872.654 ops/s
                 ·gc.alloc.rate:                   82.118 MB/sec
                 ·gc.alloc.rate.norm:              32.000 B/op
                 ·gc.churn.PS_Eden_Space:          70.313 MB/sec
                 ·gc.churn.PS_Eden_Space.norm:     27.400 B/op
                 ·gc.churn.PS_Survivor_Space:      0.021 MB/sec
                 ·gc.churn.PS_Survivor_Space.norm: 0.008 B/op
                 ·gc.count:                        1.000 counts
                 ·gc.time:                         1.000 ms

Iteration   4: 3936607.543 ops/s
                 ·gc.alloc.rate:               80.073 MB/sec
                 ·gc.alloc.rate.norm:          32.000 B/op
                 ·gc.churn.PS_Eden_Space:      136.618 MB/sec
                 ·gc.churn.PS_Eden_Space.norm: 54.597 B/op
                 ·gc.count:                    2.000 counts
                 ·gc.time:                     3.000 ms

Iteration   5: 3925840.521 ops/s
                 ·gc.alloc.rate:                   79.856 MB/sec
                 ·gc.alloc.rate.norm:              32.000 B/op
                 ·gc.churn.PS_Eden_Space:          66.312 MB/sec
                 ·gc.churn.PS_Eden_Space.norm:     26.573 B/op
                 ·gc.churn.PS_Survivor_Space:      0.042 MB/sec
                 ·gc.churn.PS_Survivor_Space.norm: 0.017 B/op
                 ·gc.count:                        1.000 counts
                 ·gc.time:                         ≈ 0 ms

Iteration   6: 4224241.850 ops/s
                 ·gc.alloc.rate:               85.919 MB/sec
                 ·gc.alloc.rate.norm:          32.003 B/op
                 ·gc.churn.PS_Eden_Space:      64.968 MB/sec
                 ·gc.churn.PS_Eden_Space.norm: 24.199 B/op
                 ·gc.count:                    1.000 counts
                 ·gc.time:                     1.000 ms

Iteration   7: 3611009.158 ops/s
                 ·gc.alloc.rate:                   73.455 MB/sec
                 ·gc.alloc.rate.norm:              32.000 B/op
                 ·gc.churn.PS_Eden_Space:          63.645 MB/sec
                 ·gc.churn.PS_Eden_Space.norm:     27.726 B/op
                 ·gc.churn.PS_Survivor_Space:      0.021 MB/sec
                 ·gc.churn.PS_Survivor_Space.norm: 0.009 B/op
                 ·gc.count:                        1.000 counts
                 ·gc.time:                         ≈ 0 ms

Iteration   8: 4185898.776 ops/s
                 ·gc.alloc.rate:                   85.147 MB/sec
                 ·gc.alloc.rate.norm:              32.000 B/op
                 ·gc.churn.PS_Eden_Space:          123.629 MB/sec
                 ·gc.churn.PS_Eden_Space.norm:     46.463 B/op
                 ·gc.churn.PS_Survivor_Space:      0.083 MB/sec
                 ·gc.churn.PS_Survivor_Space.norm: 0.031 B/op
                 ·gc.count:                        2.000 counts
                 ·gc.time:                         1.000 ms

Iteration   9: 3780957.751 ops/s
                 ·gc.alloc.rate:               76.910 MB/sec
                 ·gc.alloc.rate.norm:          32.000 B/op
                 ·gc.churn.PS_Eden_Space:      60.308 MB/sec
                 ·gc.churn.PS_Eden_Space.norm: 25.093 B/op
                 ·gc.count:                    1.000 counts
                 ·gc.time:                     1.000 ms

Iteration  10: 3945908.792 ops/s
                 ·gc.alloc.rate:               80.265 MB/sec
                 ·gc.alloc.rate.norm:          32.000 B/op
                 ·gc.churn.PS_Eden_Space:      59.313 MB/sec
                 ·gc.churn.PS_Eden_Space.norm: 23.647 B/op
                 ·gc.count:                    1.000 counts
                 ·gc.time:                     1.000 ms

Iteration  11: 3632057.210 ops/s
                 ·gc.alloc.rate:                   73.881 MB/sec
                 ·gc.alloc.rate.norm:              32.000 B/op
                 ·gc.churn.PS_Eden_Space:          115.627 MB/sec
                 ·gc.churn.PS_Eden_Space.norm:     50.082 B/op
                 ·gc.churn.PS_Survivor_Space:      0.062 MB/sec
                 ·gc.churn.PS_Survivor_Space.norm: 0.027 B/op
                 ·gc.count:                        2.000 counts
                 ·gc.time:                         1.000 ms

Iteration  12: 3961393.924 ops/s
                 ·gc.alloc.rate:               80.583 MB/sec
                 ·gc.alloc.rate.norm:          32.000 B/op
                 ·gc.churn.PS_Eden_Space:      56.318 MB/sec
                 ·gc.churn.PS_Eden_Space.norm: 22.364 B/op
                 ·gc.count:                    1.000 counts
                 ·gc.time:                     1.000 ms

Iteration  13: 3831926.058 ops/s
                 ·gc.alloc.rate:                   77.945 MB/sec
                 ·gc.alloc.rate.norm:              32.000 B/op
                 ·gc.churn.PS_Eden_Space:          109.625 MB/sec
                 ·gc.churn.PS_Eden_Space.norm:     45.007 B/op
                 ·gc.churn.PS_Survivor_Space:      0.042 MB/sec
                 ·gc.churn.PS_Survivor_Space.norm: 0.017 B/op
                 ·gc.count:                        2.000 counts
                 ·gc.time:                         1.000 ms

Iteration  14: 4159586.972 ops/s
                 ·gc.alloc.rate:               84.607 MB/sec
                 ·gc.alloc.rate.norm:          32.000 B/op
                 ·gc.churn.PS_Eden_Space:      53.313 MB/sec
                 ·gc.churn.PS_Eden_Space.norm: 20.164 B/op
                 ·gc.count:                    1.000 counts
                 ·gc.time:                     1.000 ms

Iteration  15: 3860980.041 ops/s
                 ·gc.alloc.rate:                   78.539 MB/sec
                 ·gc.alloc.rate.norm:              32.000 B/op
                 ·gc.churn.PS_Eden_Space:          103.637 MB/sec
                 ·gc.churn.PS_Eden_Space.norm:     42.226 B/op
                 ·gc.churn.PS_Survivor_Space:      0.042 MB/sec
                 ·gc.churn.PS_Survivor_Space.norm: 0.017 B/op
                 ·gc.count:                        2.000 counts
                 ·gc.time:                         2.000 ms

Iteration  16: 3909224.351 ops/s
                 ·gc.alloc.rate:               79.514 MB/sec
                 ·gc.alloc.rate.norm:          32.000 B/op
                 ·gc.churn.PS_Eden_Space:      50.646 MB/sec
                 ·gc.churn.PS_Eden_Space.norm: 20.382 B/op
                 ·gc.count:                    1.000 counts
                 ·gc.time:                     2.000 ms

Iteration  17: 3842654.884 ops/s
                 ·gc.alloc.rate:                   78.157 MB/sec
                 ·gc.alloc.rate.norm:              32.000 B/op
                 ·gc.churn.PS_Eden_Space:          99.295 MB/sec
                 ·gc.churn.PS_Eden_Space.norm:     40.655 B/op
                 ·gc.churn.PS_Survivor_Space:      0.021 MB/sec
                 ·gc.churn.PS_Survivor_Space.norm: 0.009 B/op
                 ·gc.count:                        2.000 counts
                 ·gc.time:                         5.000 ms

Iteration  18: 4020829.691 ops/s
                 ·gc.alloc.rate:               81.790 MB/sec
                 ·gc.alloc.rate.norm:          32.000 B/op
                 ·gc.churn.PS_Eden_Space:      48.653 MB/sec
                 ·gc.churn.PS_Eden_Space.norm: 19.035 B/op
                 ·gc.count:                    1.000 counts
                 ·gc.time:                     1.000 ms

Iteration  19: 3493140.117 ops/s
                 ·gc.alloc.rate:                   71.055 MB/sec
                 ·gc.alloc.rate.norm:              32.000 B/op
                 ·gc.churn.PS_Eden_Space:          95.298 MB/sec
                 ·gc.churn.PS_Eden_Space.norm:     42.918 B/op
                 ·gc.churn.PS_Survivor_Space:      0.062 MB/sec
                 ·gc.churn.PS_Survivor_Space.norm: 0.028 B/op
                 ·gc.count:                        2.000 counts
                 ·gc.time:                         2.000 ms

Iteration  20: 3821334.414 ops/s
                 ·gc.alloc.rate:                   77.724 MB/sec
                 ·gc.alloc.rate.norm:              32.000 B/op
                 ·gc.churn.PS_Eden_Space:          92.627 MB/sec
                 ·gc.churn.PS_Eden_Space.norm:     38.136 B/op
                 ·gc.churn.PS_Survivor_Space:      0.042 MB/sec
                 ·gc.churn.PS_Survivor_Space.norm: 0.017 B/op
                 ·gc.count:                        2.000 counts
                 ·gc.time:                         2.000 ms



Result "cc.microbenchmarks.core.varargs.VarargsNew5.varArgs":
  3916635.694 ±(99.9%) 175434.392 ops/s [Average]
  (min, avg, max) = (3493140.117, 3916635.694, 4266908.446), stdev = 202030.506
  CI (99.9%): [3741201.302, 4092070.085] (assumes normal distribution)

Secondary result "cc.microbenchmarks.core.varargs.VarargsNew5.varArgs:·gc.alloc.rate":
  79.668 ±(99.9%) 3.568 MB/sec [Average]
  (min, avg, max) = (71.055, 79.668, 86.795), stdev = 4.109
  CI (99.9%): [76.100, 83.236] (assumes normal distribution)

Secondary result "cc.microbenchmarks.core.varargs.VarargsNew5.varArgs:·gc.alloc.rate.norm":
  32.000 ±(99.9%) 0.001 B/op [Average]
  (min, avg, max) = (32.000, 32.000, 32.003), stdev = 0.001
  CI (99.9%): [32.000, 32.001] (assumes normal distribution)

Secondary result "cc.microbenchmarks.core.varargs.VarargsNew5.varArgs:·gc.churn.PS_Eden_Space":
  80.755 ±(99.9%) 23.053 MB/sec [Average]
  (min, avg, max) = (48.653, 80.755, 136.618), stdev = 26.548
  CI (99.9%): [57.702, 103.808] (assumes normal distribution)

Secondary result "cc.microbenchmarks.core.varargs.VarargsNew5.varArgs:·gc.churn.PS_Eden_Space.norm":
  32.638 ±(99.9%) 9.686 B/op [Average]
  (min, avg, max) = (19.035, 32.638, 54.597), stdev = 11.154
  CI (99.9%): [22.952, 42.324] (assumes normal distribution)

Secondary result "cc.microbenchmarks.core.varargs.VarargsNew5.varArgs:·gc.churn.PS_Survivor_Space":
  0.024 ±(99.9%) 0.023 MB/sec [Average]
  (min, avg, max) = (≈ 0, 0.024, 0.083), stdev = 0.026
  CI (99.9%): [0.001, 0.047] (assumes normal distribution)

Secondary result "cc.microbenchmarks.core.varargs.VarargsNew5.varArgs:·gc.churn.PS_Survivor_Space.norm":
  0.010 ±(99.9%) 0.009 B/op [Average]
  (min, avg, max) = (≈ 0, 0.010, 0.031), stdev = 0.011
  CI (99.9%): [≈ 10⁻³, 0.019] (assumes normal distribution)

Secondary result "cc.microbenchmarks.core.varargs.VarargsNew5.varArgs:·gc.count":
  28.000 ±(99.9%) 0.001 counts [Sum]
  (min, avg, max) = (1.000, 1.400, 2.000), stdev = 0.503
  CI (99.9%): [28.000, 28.000] (assumes normal distribution)

Secondary result "cc.microbenchmarks.core.varargs.VarargsNew5.varArgs:·gc.time":
  27.000 ±(99.9%) 0.001 ms [Sum]
  (min, avg, max) = (≈ 0, 1.350, 5.000), stdev = 1.137
  CI (99.9%): [27.000, 27.000] (assumes normal distribution)


# Run complete. Total time: 00:01:31

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

Process finished with exit code 0
