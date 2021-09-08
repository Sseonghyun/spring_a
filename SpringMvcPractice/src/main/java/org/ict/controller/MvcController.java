package org.ict.controller;

import java.util.Collection;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

// 빈 컨테이너에 넣어주세요. ( 등록된 컨트롤러만 실제로 작용됨 )
@Controller
public class MvcController {

	// 기본주소 (localhost:8181)뒤에 /goA를 붙이면 goA()메서드 실행
	@RequestMapping(value="/goA")
	// return 타입이 String인 경우 결과 페이지를 지정할 수 있음
	public String goA() {
		System.out.println("goA 주소 접속 감지");
		// 결과 페이지는 views 폴더 아래의 A.jsp
		return "A";
	}
	// goB를 생성해주세요.
	// 결과 페이지는 B.jsp입니다.
	@RequestMapping(value="/goB")
	public String goB() {
		System.out.println("goB 주소 접속 감지");
		return "B";
	}
	
	// goC는 파라미터를 입력받을수 있도록 해보겠습니다.
	@RequestMapping(value="/goC")
	// 주소 뒤 ? cNum=값 형태로 들어오는 값을 로직 내 cNum으로 처리합니다.
	// 들어온 파라미터를 .jsp파일로 전달하기 위해서는
	// Model model을 파라미터에 추가로 선언해줍니다.
	public String goC(int cNum, Model model) {
		System.out.println("주소로 전달받은 값 : " + cNum);
		
		model.addAttribute("cNum", cNum);
		// 전달받은 cNum을 C.jsp에 출력하는 로직을 작성해주세요.
		return "C";
	}
	
	// goD는 requestParam을 이용해 변수명과 받는 이름이 일치하지 않게 해보겠습니다.
	@RequestMapping(value="/goD")
	// @RequestParam("대체이름")은 변수 왼쪽에 선언합니다.
	// 이렇게 되면 적힌 변수명 대신 대체이름으로 치환해 받아옵니다.
	public String goD(@RequestParam("d")int dNum, Model model) {
		
		System.out.println("d 변수명으로 받은게 dNum에 저장 : " + dNum);
		
		//  받아온 변수를 D.jsp에서 출력해주세요.
		model.addAttribute("dNum", dNum);
		
		return "D";
	}
	
	// cToF 메서드를 만들겠습니다.
	// 섭씨 온도를 입력받아 화씨 온도로 바꿔서 출력해주는 로직을 작성해주세요.
	// (화씨 -32) / 1.8 = 섭씨입니다. / 화씨 = 섭씨 * 1.8 + 32
	// 파일 이름은 ctof.jsp입니다.
	// 폼에서 post방식으로 제출 했을때에만 결과페이지로 넘어오도록 설계
	@RequestMapping(value="/goctof", method=RequestMethod.POST)
	
	public String goctof(@RequestParam("cel") int cel, Model model) {
		
		double faren = cel * 1.8 + 32;
		model.addAttribute("faren", faren);
		model.addAttribute("cel", cel);
		
		return "ctof";
		
	}
	
	// 폼으로 연결하는 메서드도 만들겠습니다.
	// 폼과 결과페이지가 같은 주소를 공유하게 하기 위해서 폼쪽을 겟방식 접근 허용
	@RequestMapping(value="/goctof", method=RequestMethod.GET)
	public String goctofform() {
		
		// cotofform을 이용해 섭씨온도를 입력하고 제출버튼을 누르면
		// 결과값이 나오는 로직을 작성해주세요.
		// input 태그의 name속성은 cel로 주시면 되고
		// action은 value에 적힌 주소값으로 넘겨주시면 됩니다.
		
		return "ctofform";
	}
}
