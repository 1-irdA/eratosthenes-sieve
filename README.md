# eratosthenes-sieve

Find prime numbers with Eratosthenes sieve with mono and multi threads.     

## Benchmark

**Don't set displayNumbers at true on big benchmark.**

### Mono thread

- Prime numbers between 0 and 100 000 000 : 

time < 500 ms

- Prime numbers between 0 and 500 000 000 :

time < 2500 ms

- Prime numbers between 0 and 1 000 000 000 :

time < 5200 ms

- Prime numbers between 0 and 2 000 000 000 :

time < 11000 ms

- Prime numbers between 0 and 2 147 483 645

time < 12000 ms

### Multi threads

- Prime numbers between 0 and 100 000 000 :

time < 400 ms  

- Prime numbers between 0 and 500 000 000 : 
  
time < 2000 ms

- Prime numbers between 0 and 1 000 000 000 :

time < 3600 ms

- Prime numbers between 0 and 2 000 000 000 :

time < 7200 ms

- Prime numbers between 0 and 2 147 483 645

time < 7500 ms