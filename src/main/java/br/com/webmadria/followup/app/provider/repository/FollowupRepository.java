package br.com.webmadria.followup.app.provider.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.webmadria.followup.app.provider.model.EmailModel;

public interface FollowupRepository extends JpaRepository<EmailModel, UUID> {

}
