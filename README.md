# eratosthenes-sieve

Find prime numbers with Eratosthenes sieve with mono and multi threads.     

## Benchmark

**Don't set displayNumbers at true on big benchmark.**

### Mono thread

- Prime numbers between 0 and 100 000 000 : 

time < 750 ms

- Prime numbers between 0 and 500 000 000 :

time < 4300 ms

- Prime numbers between 0 and 1 000 000 000 :

time < 8500 ms

- Prime numbers between 0 and 2 000 000 000 :

time < 19000 ms

- Prime numbers between 0 and 2 147 483 645

time < 21000 ms

### Multi threads

- Prime numbers between 0 and 100 000 000 :

time < 500 ms  

- Prime numbers between 0 and 500 000 000 : 
  
time < 3500 ms

- Prime numbers between 0 and 1 000 000 000 :

time < 6500 ms

- Prime numbers between 0 and 2 000 000 000 :

time < 13000 ms

- Prime numbers between 0 and 2 147 483 645

time < 15000 ms