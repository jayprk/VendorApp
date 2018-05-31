package com.app.util;

import java.io.IOException;
import java.io.InputStream;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Component
public class CommonUtil {

	@Autowired
	private JavaMailSender mailSender;

	public boolean sendEmail(String to, String sub, String text,
			final CommonsMultipartFile file) {
		boolean isSent = false;
		try {
			MimeMessage message = mailSender.createMimeMessage();

			MimeMessageHelper helper = new MimeMessageHelper(message,
					file != null ? true : false);
			helper.setTo(to);
			helper.setSubject(sub);
			helper.setText(text);
			helper.setFrom("jayhavefun@gmail.com");

			if (file != null) {
				helper.addAttachment(file.getOriginalFilename(),
						new InputStreamSource() {

							@Override
							public InputStream getInputStream()
									throws IOException {
								return file.getInputStream();
							}
						});
			}

			mailSender.send(message);
			isSent = true;
		} catch (Exception e) {
			e.printStackTrace();
			isSent = false;
		}
		return isSent;
	}

	public boolean sendEmail(String to, String sub, String text) {
		return sendEmail(to, sub, text, null);
	}

}
