package watsoncui.nkcms.string.test;

import watsoncui.nkcms.string.matching.KMPMatching;
import watsoncui.nkcms.string.matching.Matching;
import watsoncui.nkcms.string.matching.MyMatch;
import watsoncui.nkcms.string.matching.SimpleMatching;

public class MatchTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Matching sm = new SimpleMatching();
		Matching kmp = new KMPMatching();
		Matching mm = new MyMatch();
		test(sm, 1000);
		test(kmp, 1000);
		test(mm, 1000);
		
		long start = System.nanoTime();
		test(sm, 100000);
		long end = System.nanoTime();
		System.out.println("SimpleMatching " + (end - start));
		
		start = System.nanoTime();
		test(kmp, 100000);
		end = System.nanoTime();
		System.out.println("KMPMatching " + (end - start));
		
		start = System.nanoTime();
		test(mm, 100000);
		end = System.nanoTime();
		System.out.println("MyMatching " + (end - start));
	}

	public static void testOnce(Matching match) {
		match.match("If you publish material based on databases obtained from this repository, then, in your acknowledgments, please note the assistance you received by using this repository. This will help others to obtain the same data sets and replicate your experiments. We suggest the following pseudo-APA reference format for referring to this repository: " + 
				"Downloading: http://repos.d.xiaonei.com/nexus/content/groups/public/org/springframework/spring-test/3.2.0.RELEASE/spring-test-3.2.0.RELEASE.pom"
				+    
				"Downloading: http://repos.d.xiaonei.com/nexus/content/groups/public/org/springframework/spring-webmvc/3.2.0.RELEASE/spring-webmvc-3.2.0.RELEASE.pom"
				+      
				"Downloading: http://repos.d.xiaonei.com/nexus/content/groups/public/org/springframework/spring-context/3.2.0.RELEASE/spring-context-3.2.0.RELEASE.pom"
				+      
				"Downloading: http://repos.d.xiaonei.com/nexus/content/groups/public/org/springframework/spring-core/3.2.0.RELEASE/spring-core-3.2.0.RELEASE.pom"
				+      
				"Downloading: http://repos.d.xiaonei.com/nexus/content/groups/public/org/springframework/spring-aop/3.2.0.RELEASE/spring-aop-3.2.0.RELEASE.pom"
				+      
				"Downloading: http://repos.d.xiaonei.com/nexus/content/groups/public/org/springframework/spring-beans/3.2.0.RELEASE/spring-beans-3.2.0.RELEASE.pom"
				+      
				"Downloading: http://repos.d.xiaonei.com/nexus/content/groups/public/org/springframework/spring-expression/3.2.0.RELEASE/spring-expression-3.2.0.RELEASE.pom"
				+      
				"Downloading: http://repos.d.xiaonei.com/nexus/content/groups/public/org/springframework/spring-web/3.2.0.RELEASE/spring-web-3.2.0.RELEASE.pom"
				+      
				"Downloading: http://repos.d.xiaonei.com/nexus/content/groups/public/org/hibernate/hibernate-entitymanager/4.1.9.Final/hibernate-entitymanager-4.1.9.Final.pom"
				+      
				"Downloading: http://repos.d.xiaonei.com/nexus/content/groups/public/org/jboss/logging/jboss-logging/3.1.0.GA/jboss-logging-3.1.0.GA.pom"
				+      
				"Downloading: http://repos.d.xiaonei.com/nexus/content/groups/public/org/jboss/jboss-parent/7/jboss-parent-7.pom"
				+       
				"Downloading: http://repos.d.xiaonei.com/nexus/content/groups/public/org/javassist/javassist/3.17.1-GA/javassist-3.17.1-GA.pom"
				+      
				"Downloading: http://repos.d.xiaonei.com/nexus/content/groups/public/org/jboss/spec/javax/transaction/jboss-transaction-api_1.1_spec/1.0.0.Final/jboss-transaction-api_1.1_spec-1.0.0.Final.pom"
				+      
				"Downloading: http://repos.d.xiaonei.com/nexus/content/groups/public/org/jboss/spec/jboss-specs-parent/1.0.0.Beta2/jboss-specs-parent-1.0.0.Beta2.pom"
				+      
				"Downloading: http://repos.d.xiaonei.com/nexus/content/groups/public/org/jboss/jboss-parent/5/jboss-parent-5.pom"
				+       
				"Downloading: http://repos.d.xiaonei.com/nexus/content/groups/public/org/hibernate/javax/persistence/hibernate-jpa-2.0-api/1.0.1.Final/hibernate-jpa-2.0-api-1.0.1.Final.pom"
				+      
				"Downloading: http://repos.d.xiaonei.com/nexus/content/groups/public/org/hibernate/hibernate-core/4.1.9.Final/hibernate-core-4.1.9.Final.pom"
				+      
				"Downloading: http://repos.d.xiaonei.com/nexus/content/groups/public/org/hibernate/common/hibernate-commons-annotations/4.0.1.Final/hibernate-commons-annotations-4.0.1.Final.pom"
				+       
				"Downloading: http://repos.d.xiaonei.com/nexus/content/groups/public/org/jboss/logging/jboss-logging/3.1.0.CR2/jboss-logging-3.1.0.CR2.pom"
				+      
				"Downloading: http://repos.d.xiaonei.com/nexus/content/groups/public/org/jboss/jboss-parent/6/jboss-parent-6.pom"
				+       
				"Downloading: http://repos.d.xiaonei.com/nexus/content/groups/public/mysql/mysql-connector-java/5.1.22/mysql-connector-java-5.1.22.pom"
				+      
				"Downloading: http://repos.d.xiaonei.com/nexus/content/groups/public/com/h2database/h2/1.3.170/h2-1.3.170.pom"
				+     
				"Downloading: http://repos.d.xiaonei.com/nexus/content/groups/public/org/springframework/data/spring-data-jpa/1.2.0.RELEASE/spring-data-jpa-1.2.0.RELEASE.pom"
				+       
				"Downloading: http://repos.d.xiaonei.com/nexus/content/groups/public/org/springframework/data/spring-data-commons-core/1.4.0.RELEASE/spring-data-commons-core-1.4.0.RELEASE.pom"
				+      
				"Downloading: http://repos.d.xiaonei.com/nexus/content/groups/public/org/springframework/data/spring-data-commons-parent/1.4.0.RELEASE/spring-data-commons-parent-1.4.0.RELEASE.pom"
				+      
				"Downloading: http://repos.d.xiaonei.com/nexus/content/groups/public/org/springframework/spring-core/3.1.2.RELEASE/spring-core-3.1.2.RELEASE.pom"
				+      
				"Downloading: http://repos.d.xiaonei.com/nexus/content/groups/public/org/springframework/spring-parent/3.1.2.RELEASE/spring-parent-3.1.2.RELEASE.pom"
				+      
				"Downloading: http://repos.d.xiaonei.com/nexus/content/groups/public/org/springframework/spring-beans/3.1.2.RELEASE/spring-beans-3.1.2.RELEASE.pom"
				+      
				"Downloading: http://repos.d.xiaonei.com/nexus/content/groups/public/org/springframework/spring-orm/3.1.2.RELEASE/spring-orm-3.1.2.RELEASE.pom"
				+      
				"Downloading: http://repos.d.xiaonei.com/nexus/content/groups/public/org/springframework/spring-jdbc/3.1.2.RELEASE/spring-jdbc-3.1.2.RELEASE.pom"
				+      
				"Downloading: http://repos.d.xiaonei.com/nexus/content/groups/public/org/springframework/spring-tx/3.1.2.RELEASE/spring-tx-3.1.2.RELEASE.pom"
				+      
				"Downloading: http://repos.d.xiaonei.com/nexus/content/groups/public/org/springframework/spring-aop/3.1.2.RELEASE/spring-aop-3.1.2.RELEASE.pom"
				+      
				"Downloading: http://repos.d.xiaonei.com/nexus/content/groups/public/org/springframework/spring-context/3.1.2.RELEASE/spring-context-3.1.2.RELEASE.pom"
				+      
				"Downloading: http://repos.d.xiaonei.com/nexus/content/groups/public/org/springframework/spring-asm/3.1.2.RELEASE/spring-asm-3.1.2.RELEASE.pom"
				+      
				"Downloading: http://repos.d.xiaonei.com/nexus/content/groups/public/org/springframework/spring-expression/3.1.2.RELEASE/spring-expression-3.1.2.RELEASE.pom"
				+      
				"Downloading: http://repos.d.xiaonei.com/nexus/content/groups/public/org/slf4j/jcl-over-slf4j/1.6.1/jcl-over-slf4j-1.6.1.pom"
				+      
				"Downloading: http://repos.d.xiaonei.com/nexus/content/groups/public/org/aspectj/aspectjrt/1.6.12/aspectjrt-1.6.12.pom", "http://repos.d.xiaonei.com/nexus/content/groups/public/org/springframework/spring");
	}
	
	public static void test(Matching match, int times) {
		for(int i = 0; i < times; i++) {
			testOnce(match);
		}
	}
}