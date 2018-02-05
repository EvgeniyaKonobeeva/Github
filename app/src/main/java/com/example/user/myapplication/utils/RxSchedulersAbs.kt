package com.example.user.myapplication.utils


import io.reactivex.FlowableTransformer
import io.reactivex.Scheduler
import io.reactivex.SingleTransformer

abstract class RxSchedulersAbs {

    abstract val mainThreadScheduler: Scheduler
    abstract val ioScheduler: Scheduler
    abstract val computationScheduler: Scheduler

    fun <T> getIOToMainTransformerSingle(): SingleTransformer<T, T> =
         SingleTransformer {
            upstream ->  upstream.apply {
                subscribeOn(ioScheduler)
                observeOn(mainThreadScheduler)
            }
        }


    fun <T> getIOToMainTransformerFlowable(): FlowableTransformer<T, T> =
            FlowableTransformer {
                upstream ->  upstream.apply {
                subscribeOn(ioScheduler)
                observeOn(mainThreadScheduler)
            }
            }


    fun <T> getComputationToMainTransformerSingle(): SingleTransformer<T, T> =
            SingleTransformer {
                    upstream ->  upstream.apply {
                        subscribeOn(this@RxSchedulersAbs.computationScheduler)
                        observeOn(this@RxSchedulersAbs.mainThreadScheduler)
                }
            }


    fun <T> getComputationToMainTransformerFlowable(): FlowableTransformer<T, T> =
            FlowableTransformer {
                upstream ->  upstream.apply {
                subscribeOn(this@RxSchedulersAbs.computationScheduler)
                observeOn(this@RxSchedulersAbs.mainThreadScheduler)
            }
            }

}
