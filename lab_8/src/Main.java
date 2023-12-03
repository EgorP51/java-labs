import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

public class Main {
    static final private int MAX_NUMBER = 100;

    public static void main(String[] args) {
        final List<Integer> list = IntStream.generate(() -> new Random().nextInt(MAX_NUMBER)).limit(MAX_NUMBER + 1).boxed().toList();
        final RecursiveTargetImpl recursiveTask = new RecursiveTargetImpl(list);
        System.out.println(recursiveTask.compute());
    }
}

class RecursiveTargetImpl extends RecursiveTask<Integer> {
    private static final int THRESHOLD = 20;
    private final List<Integer> array;


    public RecursiveTargetImpl(List<Integer> arr) {
        this.array = arr;
    }

    @Override
    protected Integer compute() {
        if (array.size() > THRESHOLD) {
            return ForkJoinTask.invokeAll(createSubtasks()).stream().mapToInt(ForkJoinTask::join).sum();
        } else {
            return processing(array);
        }
    }

    private Collection<RecursiveTargetImpl> createSubtasks() {
        final List<RecursiveTargetImpl> dividedTasks = new ArrayList<>();
        final List<Integer> partOne = array.subList(0, array.size() / 2);
        final List<Integer> partTwo = array.subList(array.size() / 2, array.size());

        dividedTasks.add(new RecursiveTargetImpl(partOne));
        dividedTasks.add(new RecursiveTargetImpl(partTwo));

        return dividedTasks;
    }

    private Integer processing(List<Integer> arr) {
        System.out.println(arr);
        return arr.stream().mapToInt(Integer::intValue).sum();
    }
}