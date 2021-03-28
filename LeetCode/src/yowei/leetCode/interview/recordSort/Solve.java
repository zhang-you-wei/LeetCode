package yowei.leetCode.interview.recordSort;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solve {
    public List<Record> foo(File file) throws IOException, ClassNotFoundException {

        //使用最大堆存储数据
        PriorityQueue<Record> pq = new PriorityQueue<>(new Comparator<Record>() {
            @Override
            public int compare(Record o1, Record o2) {
                return o2.id - o1.id;
            }
        });

        FileInputStream fileIn = new FileInputStream(file);
        ObjectInputStream objectIn = new ObjectInputStream(new BufferedInputStream(fileIn));        //缓冲输入流读取文件，避免爆内存
        Object obj=null;

        while((obj = objectIn.readObject())!=null){  // 如果读到的对象为空则退出循环
            Record  curRecord =(Record) obj; //读取对象，

            //数量大于128且id值小于堆顶元素时将堆顶元素弹出
            if(pq.size() >= 128 ){
                if(curRecord.id < pq.peek().id){
                    pq.poll();
                    pq.add(curRecord);
                }

            }else{
                pq.add(curRecord);           //加入新元素
            }


        }

        return new ArrayList<>(pq);
    }


    public static void main(String[] args) {

        /*
        //测试输入
        File file =new File("test");
        FileOutputStream out;
        try {
            out = new FileOutputStream(file);
            ObjectOutputStream objOut=new ObjectOutputStream(out);
            for (int i = 0; i < 5; i++) {
                Record r = new Record(i);
                objOut.writeObject(r);
            }

            //结尾处要写一个null不然后报错
            objOut.writeObject(null);
            objOut.flush();
            objOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        Solve solve = new Solve();
        try {
            List<Record> test = solve.foo(new File("test"));
            System.out.println(test);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
