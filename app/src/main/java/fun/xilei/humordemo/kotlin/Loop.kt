package `fun`.xilei.humordemo.kotlin

class Loop private constructor(){
    companion object{
        fun get():Loop{
            return Holder.instance
        }
    }

    private object Holder{
        val instance = Loop()
    }

    fun run(){
        for (i in 1..10){
            print("Loop1 $i")
        }

        for (i in 1 until 10) {
            print("Loop2 $i")
        }

        for (i in 10 downTo 1) {
            print("Loop3 $i")
        }

        for (i in 10 downTo 1 step 2) {
            print("Loop4 $i")
        }

    }
}