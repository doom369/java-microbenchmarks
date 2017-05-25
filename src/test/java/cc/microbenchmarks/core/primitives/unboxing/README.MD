Result :

```
Benchmark                        Mode  Cnt  Score   Error  Units
TestBenchmark.initInt            avgt    5  2.198 ± 0.054  ns/op
TestBenchmark.initInteger        avgt    5  3.459 ± 0.521  ns/op
TestBenchmark.initIntegerCached  avgt    5  2.517 ± 0.273  ns/op
```

Explanation : 

```initInt``` simply creates primitive of ```int``` type. ```initInteger``` creates object wrapper for int. Benchmark 
shows that wrapper creation is ~1.5 times slower. This is because ```initInteger``` allocates object on heap and GC is involved 
to gather created instance. 
```initIntegerCached``` performance pretty close to primitive creation (only 10% slower). Explanation is pretty simple - 
java caches by default 255 int values, so in this example real allocation of int wrapper is not happening.

This is code from Integer class : 

```
public static Integer valueOf(int i) {
    if (i >= IntegerCache.low && i <= IntegerCache.high)
       return IntegerCache.cache[i + (-IntegerCache.low)];
    return new Integer(i);
}
```


