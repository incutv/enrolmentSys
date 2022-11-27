package net.skhu.service;

import net.skhu.service.strategy.MailStrategy;

public class MailService {

	public boolean sign(MailStrategy mailStrategy, String email, String name) {
		return mailStrategy.sign(email, name);
	}

	public boolean withraw(MailStrategy mailStrategy, String email, String name) {
		return mailStrategy.withraw(email, name);
	}
}
