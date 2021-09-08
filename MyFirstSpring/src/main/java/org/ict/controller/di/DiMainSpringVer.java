package org.ict.controller.di;

import org.ict.controller.di.classfile.Broadcast;
import org.ict.controller.di.classfile.Satellite;
import org.ict.controller.di.classfile.Singer;
import org.ict.controller.di.classfile.Stage;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DiMainSpringVer {
	public static void main(String[] args) {
		// �� �����̳ʿ� ȣ���� �ϼ�ǰ ��ü�� �޾ƿ� �����ϴ� �ڵ带 �ۼ��غ��ڽ��ϴ�.
		// ȣ��� ����ϴ� ������ ��ü�� GenericXmlApplicationContext �Դϴ�
		GenericXmlApplicationContext context = new GenericXmlApplicationContext(
				"file:src/main/webapp/WEB-INF/spring/root-context.xml");

		// ���� root-context.xml�̶�� bean-container�� ������ �ϰڴٰ� ������ ������
		// ���� �� ���忡 �ִ� ��ü�� ������� ���� ���� �ִ�.
		// ������ ����� ���� ������ context ��ü�� �̿���
		// context.getBean("bean�̸�",�ڷ���.class); �Դϴ�.
		Singer singer = context.getBean("singer", Singer.class);
		singer.sing();

		Stage stage = context.getBean("stage", Stage.class);
		stage.perform();

		Broadcast broadcast = context.getBean("broadcast", Broadcast.class);
		broadcast.broadcast();
		
		Satellite satellite = context.getBean("satellite", Satellite.class);
		satellite.satellite();

		// ȣ���� ������ context�� �ݾ���� �մϴ�.
		context.close();
	}

}