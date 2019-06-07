package org.parkg.book.chap13;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.parkg.book.chap11.Member;
import org.parkg.book.chap11.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * p.356 [리스트 13.6] 로그인 컨트롤러 수정
 * 
 * @author Jacob
 */
@Controller
public class LoginController {

	@Autowired
	MemberDao memberDao;

	static final Logger logger = LogManager.getLogger();

	/**
	 * 로그인 화면
	 */
	@GetMapping("/loginForm")
	public String form() {
		return "login/loginForm";
	}

	/**
	 * 로그인을 실행
	 */
	@PostMapping("/login")
	public String submit(@RequestParam("email") String email,
			@RequestParam("password") String password,
			@RequestParam("returnUrl") String returnUrl, HttpSession session) {
		try {
			Member member = memberDao.selectByLogin(email, password);
			session.setAttribute("MEMBER", member);
			logger.debug("로그인 성공. {}", member);
			return "redirect:" + returnUrl;
		} catch (EmptyResultDataAccessException e) {
			logger.debug("로그인 실패. email={}", email);
			return "redirect:/app/loginForm?mode=FAILURE&email=" + email
					+ "&returnUrl=" + returnUrl;
		}
	}

	/**
	 * p.362 [리스트 13.3] LogoutController의 logout() 메서드 로그 아웃
	 */
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}