package com.techie.spring.cassandra.api;

import com.techie.spring.cassandra.api.model.Author;
import com.techie.spring.cassandra.api.model.Book;
import com.techie.spring.cassandra.api.model.Company;
import com.techie.spring.cassandra.api.repository.AuthorRepository;
import com.techie.spring.cassandra.api.repository.BookRepository;
import com.techie.spring.cassandra.api.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SpringCassandraApiApplication {

	@Autowired
	AuthorRepository authorRepository;

	@Autowired
	BookRepository bookRepository;

	@Autowired
	CompanyRepository companyRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringCassandraApiApplication.class, args);
	}

	@PostConstruct
	public void start(){
		//initAuthor();
		//initBook();
		//initCompany();
		//getCompanyById("149586");
		//getCompanyByName("USBank");
		//deleteCompanyById("1834");
		//updateCompanyById("149586");
		getAllCompany();
	}

	private void getCompanyById(String companyId) {
		Optional<Company> companyOptional = companyRepository.findById(companyId);
		if (companyOptional.isPresent()) {
			Company company = companyOptional.get();
			System.out.println("Company found : " + company.toString());
		}
	}

	private void getAllCompany() {
		List<Company> companyList = companyRepository.findAll();
		System.out.println("All Companies : " + companyList.size());
		companyList.forEach(c -> System.out.println(c));
	}

	private void getCompanyByName(String companyName) {
		Company company = companyRepository.findByCompanyName(companyName);
		System.out.println("Company details found : " + company.toString());
	}

	private void deleteCompanyById(String companyId) {
		companyRepository.deleteById(companyId);
		System.out.println("Company deleted : " + companyId);
	}

	private void updateCompanyById(String companyId) {
		Optional<Company> companyOptional = companyRepository.findById(companyId);
		if (companyOptional.isPresent()) {
			Company company = companyOptional.get();
			company.setUniqueBusinessIdentifier("CT");
			companyRepository.save(company);
			System.out.println("Company saved : " + company.toString());
		}
	}



	private void initCompany() {
		Company company = new Company("149586", "USBank", "CTS");
		System.out.println("Inserting the Company Object");
		companyRepository.save(company);
		System.out.println("Data saved successfully.");
	}

	private void initBook() {
		Book book = new Book();
		book.setId("455");
		book.setName("The C");
		book.setDescription("Language for programming");
		book.setPublishedDate(LocalDate.now());
		book.setCoverIds(Arrays.asList("First", "Second", "Third"));
		book.setAuthorNames(Arrays.asList("Gaurav","Nayan","Pratik"));
		book.setAuthorIds(Arrays.asList("123","124"));

		System.out.println("Inserting the Book Object");
		bookRepository.save(book);
	}

	private void initAuthor() {
		Author author = new Author();
		author.setId("124");
		author.setName("Nayan");
		author.setPersonalName("Dewas");

		System.out.println("Inserting the author object");
		authorRepository.save(author);
	}

}
