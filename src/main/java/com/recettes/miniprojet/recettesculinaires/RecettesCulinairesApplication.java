package com.recettes.miniprojet.recettesculinaires;

import com.recettes.miniprojet.recettesculinaires.repositories.RoleDao;
import com.recettes.miniprojet.recettesculinaires.repositories.UtilisateurDao;
import com.recettes.miniprojet.recettesculinaires.security.bean.Role;
import com.recettes.miniprojet.recettesculinaires.security.bean.Utilisateur;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;
import java.util.List;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "recettes-culinaires", version = "1.0", description = "RecettesCulinaires"))
public class RecettesCulinairesApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RecettesCulinairesApplication.class, args);
	}

	@Autowired
	private UtilisateurDao userDao;
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Override
	public void run(String... args) throws Exception {

		if (roleDao.findByName("ROLE_ADMIN").isEmpty() && roleDao.findByName("ROLE_USER").isEmpty() ){
			roleDao.saveAll(List.of(new Role("ROLE_ADMIN"),new Role("ROLE_USER")));
		}

		Utilisateur user = new Utilisateur();
		user.setNom("yazid");
		user.setAge(25);
		user.setEmail("yazidjakan0@gmail.com");
		user.setPassword(passwordEncoder.encode("123"));

		if (userDao.findByEmail(user.getEmail()) == null) {

			Role role = new Role("ROLE_ADMIN");
			user.setRoles(Collections.singleton(role));

			Utilisateur save = userDao.save(user);

			System.out.println("**************");

		}
	}

}
