package org.parkg.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Default mapping controller<br/>
 * 매핑이 없는 URL은 URL과 같은 view로 forward
 * 
 * @author Jacob
 */
@Controller
public class DefaultController {

	static final Logger logger = LogManager.getLogger();

	@GetMapping("/**")
	public void mapDefault() {
		logger.debug("Map default.");
	}
}