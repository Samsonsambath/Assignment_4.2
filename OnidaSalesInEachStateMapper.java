package mapreduce.assignment.task3;

import java.io.IOException;
import java.util.regex.Pattern;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class OnidaSalesInEachStateMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
	String onida = "Onida";
	public void map(LongWritable Key, Text Value, Context context) throws IOException, InterruptedException {
		String[] lineArray = Value.toString().split(Pattern.quote("|"));
		Text state_name = new Text(lineArray[3]);
		if (onida.equalsIgnoreCase(lineArray[0])) {			
			IntWritable count = new IntWritable(1);
			context.write(state_name, count);
		}
		else{
			IntWritable dontCount = new IntWritable(0);
			context.write(state_name, dontCount);
		}
	}

}
