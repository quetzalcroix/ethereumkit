package io.horizontalsystems.ethereumkit


object RxBaseTest {

    fun setup() {
//        val immediate = object : Scheduler() {
//            override fun createWorker(): Scheduler.Worker {
//                return ExecutorScheduler.ExecutorWorker(Executor { it.run() })
//            }
//        }
//        //https://medium.com/@fabioCollini/testing-asynchronous-rxjava-code-using-mockito-8ad831a16877
//        RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }
//        RxJavaPlugins.setComputationSchedulerHandler { Schedulers.trampoline() }
//        RxJavaPlugins.setNewThreadSchedulerHandler { Schedulers.trampoline() }
//        RxAndroidPlugins.setInitMainThreadSchedulerHandler{ immediate }
    }

}
