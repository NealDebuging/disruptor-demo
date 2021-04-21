getting familiar with disruptor and apply the event graph

1. quick start reference
https://www.baeldung.com/java-ring-buffer
https://www.baeldung.com/lmax-disruptor-concurrency
https://lmax-exchange.github.io/disruptor/user-guide/index.html#_using_the_disruptor
   
2. read and comprehension
what is false sharing? why AtomicLong has this false sharing issue, how to fix it?
   https://www.baeldung.com/java-false-sharing-contended
   use padding to avoid false sharing caused by CPU spatial locality
   
3. run demo 
   
4. try dependency graph
- The ApplicationConsumer depends on the JournalConsumer and ReplicationConsumer. 
    

   