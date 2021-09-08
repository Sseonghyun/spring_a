package org.ict.controller;

import java.util.Collection;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

// �� �����̳ʿ� �־��ּ���. ( ��ϵ� ��Ʈ�ѷ��� ������ �ۿ�� )
@Controller
public class MvcController {

	// �⺻�ּ� (localhost:8181)�ڿ� /goA�� ���̸� goA()�޼��� ����
	@RequestMapping(value="/goA")
	// return Ÿ���� String�� ��� ��� �������� ������ �� ����
	public String goA() {
		System.out.println("goA �ּ� ���� ����");
		// ��� �������� views ���� �Ʒ��� A.jsp
		return "A";
	}
	// goB�� �������ּ���.
	// ��� �������� B.jsp�Դϴ�.
	@RequestMapping(value="/goB")
	public String goB() {
		System.out.println("goB �ּ� ���� ����");
		return "B";
	}
	
	// goC�� �Ķ���͸� �Է¹����� �ֵ��� �غ��ڽ��ϴ�.
	@RequestMapping(value="/goC")
	// �ּ� �� ? cNum=�� ���·� ������ ���� ���� �� cNum���� ó���մϴ�.
	// ���� �Ķ���͸� .jsp���Ϸ� �����ϱ� ���ؼ���
	// Model model�� �Ķ���Ϳ� �߰��� �������ݴϴ�.
	public String goC(int cNum, Model model) {
		System.out.println("�ּҷ� ���޹��� �� : " + cNum);
		
		model.addAttribute("cNum", cNum);
		// ���޹��� cNum�� C.jsp�� ����ϴ� ������ �ۼ����ּ���.
		return "C";
	}
	
	// goD�� requestParam�� �̿��� �������� �޴� �̸��� ��ġ���� �ʰ� �غ��ڽ��ϴ�.
	@RequestMapping(value="/goD")
	// @RequestParam("��ü�̸�")�� ���� ���ʿ� �����մϴ�.
	// �̷��� �Ǹ� ���� ������ ��� ��ü�̸����� ġȯ�� �޾ƿɴϴ�.
	public String goD(@RequestParam("d")int dNum, Model model) {
		
		System.out.println("d ���������� ������ dNum�� ���� : " + dNum);
		
		//  �޾ƿ� ������ D.jsp���� ������ּ���.
		model.addAttribute("dNum", dNum);
		
		return "D";
	}
	
	// cToF �޼��带 ����ڽ��ϴ�.
	// ���� �µ��� �Է¹޾� ȭ�� �µ��� �ٲ㼭 ������ִ� ������ �ۼ����ּ���.
	// (ȭ�� -32) / 1.8 = �����Դϴ�. / ȭ�� = ���� * 1.8 + 32
	// ���� �̸��� ctof.jsp�Դϴ�.
	// ������ post������� ���� ���������� ����������� �Ѿ������ ����
	@RequestMapping(value="/goctof", method=RequestMethod.POST)
	
	public String goctof(@RequestParam("cel") int cel, Model model) {
		
		double faren = cel * 1.8 + 32;
		model.addAttribute("faren", faren);
		model.addAttribute("cel", cel);
		
		return "ctof";
		
	}
	
	// ������ �����ϴ� �޼��嵵 ����ڽ��ϴ�.
	// ���� ����������� ���� �ּҸ� �����ϰ� �ϱ� ���ؼ� ������ �ٹ�� ���� ���
	@RequestMapping(value="/goctof", method=RequestMethod.GET)
	public String goctofform() {
		
		// cotofform�� �̿��� �����µ��� �Է��ϰ� �����ư�� ������
		// ������� ������ ������ �ۼ����ּ���.
		// input �±��� name�Ӽ��� cel�� �ֽø� �ǰ�
		// action�� value�� ���� �ּҰ����� �Ѱ��ֽø� �˴ϴ�.
		
		return "ctofform";
	}
}