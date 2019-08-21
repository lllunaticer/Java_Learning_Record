package Java并发编程基础;
//书本86页
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
/*结果显示优先级1和优先级10的job计数的结果非常相近，没有明显的差距。这表示程序正确性不能依赖线程的优先级高低*/
public class Priority {
    private  static volatile boolean notStart = true;
    private static volatile boolean notEnd = true;

    public static void main(String[] args) throws Exception{
        List<Job> jobs = new ArrayList<>();
        for(int i = 0; i<10; i++){
            int priority = i < 5? Thread.MIN_PRIORITY : Thread.MAX_PRIORITY;
            Job job = new Job(priority);
            jobs.add(job);
            Thread thread = new Thread(job, "THread:"+i);
            thread.setPriority(priority);
            thread.start();
        }
        notStart = false;
        TimeUnit.SECONDS.sleep(10);
        notEnd = false;

        for(Job job:jobs){
            System.out.println("Job Priority : " + job.priority + ", Count : " + job.jobCount);
        }
    }

    static class Job implements Runnable{
        private int priority;
        private long jobCount;
        public Job(int priority){
            this.priority = priority;
        }

        @Override
        public void run(){
            while(notStart){
                Thread.yield();
            }
            while(notEnd){
                Thread.yield();
                jobCount++;
            }
        }
    }
}
