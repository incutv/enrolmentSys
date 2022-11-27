package net.skhu.service.strategy;

public interface MailStrategy {
	boolean sign(String email, String name);
	boolean withraw(String email, String name);
}
