import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.*;

import java.io.IOException;
import java.util.Iterator;
import java.util.StringTokenizer;

/**
 * Created by zhangjian on 2016/11/17.
 */
public class WordCount {
    public static class Map extends MapReduceBase implements Mapper<LongWritable,Text,Text,IntWritable>{

        private final static IntWritable one = new IntWritable();
        private Text word = new Text();
        @Override
        public void map(LongWritable longWritable, Text value, OutputCollector<Text, IntWritable> outputCollector, Reporter reporter) throws IOException {
            String line = value.toString();
            StringTokenizer tokenizer = new StringTokenizer(line);
            while (tokenizer.hasMoreTokens()){
                word.set(tokenizer.nextToken());
                outputCollector.collect(word,one);
            }
        }

        public static class Reduce extends MapReduceBase implements Reducer<Text, IntWritable, Text, IntWritable> {


            @Override
            public void reduce(Text key, Iterator<IntWritable> values, OutputCollector<Text, IntWritable> outputCollector, Reporter reporter) throws IOException {
                int sum = 0;
                while (values.hasNext()) {
                    sum += values.next().get();
                }

                outputCollector.collect(key,new IntWritable());
            }
        }


        public static void main(String[] args) throws IOException {
            JobConf conf = new JobConf(WordCount.class);

            conf.set("fs.default.name", "hdfs://192.168.5.128:9000");

            conf.set("hadoop.job.user", "hadoop");

            conf.set("mapred.job.tracker", "192.168.5.128:9001");


            conf.setJobName("WordCount");
            conf.setOutputKeyClass(Text.class);
            conf.setOutputValueClass(IntWritable.class);


            conf.setMapperClass(Map.class);
            conf.setCombinerClass(Reduce.class);
            conf.setReducerClass(Reduce.class);

            conf.setInputFormat(TextInputFormat.class);
            conf.setOutputFormat(TextOutputFormat.class);

            String[] params = {"/home/hadoop/data/input", "/home/hadoop/data/output"};

            FileInputFormat.setInputPaths(conf, new Path(args[0]));
            FileOutputFormat.setOutputPath(conf,new Path(args[1]));
            JobClient.runJob(conf);

        }
    }
}
