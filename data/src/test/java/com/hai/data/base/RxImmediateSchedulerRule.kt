package com.hai.data.base

import io.reactivex.Scheduler
import io.reactivex.disposables.Disposable
import io.reactivex.internal.schedulers.ExecutorScheduler
import io.reactivex.plugins.RxJavaPlugins
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement
import java.util.concurrent.ScheduledThreadPoolExecutor
import java.util.concurrent.TimeUnit


class RxImmediateSchedulerRule : TestRule {
    private val immediate = object : Scheduler() {

        override fun scheduleDirect(run: Runnable, delay: Long, unit: TimeUnit): Disposable {
            return super.scheduleDirect(run, 0, unit)
        }

        override fun createWorker(): Worker {
            return ExecutorScheduler.ExecutorWorker(object : ScheduledThreadPoolExecutor(1) {
                override fun execute(command: Runnable?) {
                    command?.run()
                }
            }, true)
        }
    }

    override fun apply(base: Statement?, description: Description?): Statement {
        return object : Statement() {
            @Throws(Throwable::class)
            override fun evaluate() {
                RxJavaPlugins.setIoSchedulerHandler { immediate }
                RxJavaPlugins.setComputationSchedulerHandler { immediate }
                RxJavaPlugins.setNewThreadSchedulerHandler { immediate }
                try {
                    base?.evaluate()
                } finally {
                    RxJavaPlugins.reset()
                }
            }
        }
    }
}