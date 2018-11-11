package com.jfernandez.microstreaminganalytics;

import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Produce;
import org.apache.camel.test.spring.CamelSpringBootRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(CamelSpringBootRunner.class)
@SpringBootTest(classes = {MicroStreamingAnalyticsApplication.class},
		properties = {"rabbit.uri = " + MicroStreamingAnalyticsApplicationTests.READER_URI,
				"mongo.uri = " + MicroStreamingAnalyticsApplicationTests.SENDER_URI})
@Slf4j
public class MicroStreamingAnalyticsApplicationTests {

	public static final String READER_URI = "browse:readerMock";
	public static final String SENDER_URI = "browse:senderMock";

	@Produce(uri = READER_URI)
	private ReaderMock readerMock;

	@Test
	public void contextLoads() {
	}

	@Test
	public void flowTest() throws InterruptedException {


		Thread.sleep(10000);

		log.debug("Fin test");
	}
}
