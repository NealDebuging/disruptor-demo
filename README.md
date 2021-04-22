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
- stuck at how to use ringBuffer.addGatingSequences();??? 
  go to the github and search in the official repository
   so Basically wen don't need to use addGatingSequences, 
  since disruptor provide the DSL handleEventWith/then which is basically
  the same as 
  new BatchEventProcessor<T>(ringBuffer, barrier, eventHandler)
  processorSequences[i] = batchEventProcessor.getSequence();
  return new EventHandlerGroup<T>(this, consumerRepository, processorSequences);
   then addGatingSequences

5. build event tree [todo] 
   
6. check how does soul use disruptor
   https://github.com/dromara/soul
   https://github.com/dromara/soul/tree/master/soul-disruptor
   well looks like dromara only documented disruptor for hmily on weichat
   
5. try to analyze disruptor usage in hmily
    after compare hmily and soul, looks like soul is a refactor versin of hmily's disruptor,
   much more clear structure and easy to understand, we can use this as cutpoint to learn about those 2 modules.
   
6. learn hmily and soul's disruptor
   

   