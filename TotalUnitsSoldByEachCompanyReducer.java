package mapreduce.assignment.task2;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class TotalUnitsSoldByEachCompanyReducer extends Reducer<Text, IntWritable, Text, IntWritable>
{	
	private IntWritable total = new IntWritable();
	@Override
	public void reduce(Text key, Iterable<IntWritable> values,Context context) throws IOException, InterruptedException
	{
		Integer count = 0;
		for ( IntWritable value : values ) 
		{
			count++;
		}
		total.set(count);
		context.write(key, total);
	}
}
