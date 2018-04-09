import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.netbeans.lib.profiler.heap.HeapFactory;
import org.netbeans.modules.profiler.oql.engine.api.OQLEngine;

/**
 * 测试OQL
 * 
 * @author zhangzhiwang
 * @date 2018年3月28日 下午7:34:39
 */
public class TestOQL {
	public static void main(String[] args) throws Exception {
		final List<String> nameList = new ArrayList<>();
		OQLEngine oqlEngine = new OQLEngine(HeapFactory.createHeap(new File("/Users/zhangzhiwang/Documents/jvm_in_action/dump/TraceStudent.hprof")));
		String oql = "select s.name.toString() from Student s";
		oqlEngine.executeQuery(oql, new OQLEngine.ObjectVisitor() {
			
			@Override
			public boolean visit(Object arg0) {
				nameList.add((String)arg0);
				return false;
			}
		});
		
		System.out.println(nameList);
	}
}
