Result :

```
Benchmark                         Mode  Cnt  Score   Error  Units
IntVsInteger.doNothing            avgt   20  0.268 ± 0.006  ns/op
IntVsInteger.initExplicitInteger  avgt   20  3.981 ± 0.104  ns/op
IntVsInteger.initImplicitInteger  avgt   20  4.073 ± 0.145  ns/op
IntVsInteger.initInt              avgt   20  2.236 ± 0.018  ns/op
IntVsInteger.initIntegerCached    avgt   20  2.786 ± 0.043  ns/op
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


