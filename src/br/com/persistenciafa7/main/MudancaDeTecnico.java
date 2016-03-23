package br.com.persistenciafa7.main;

import java.util.Collection;
import java.util.Iterator;

import org.hibernate.Session;

import br.com.persistenciafa7.dao.TimeDao;
import br.com.persistenciafa7.model.Pessoa;
import br.com.persistenciafa7.model.Tecnico;
import br.com.persistenciafa7.model.Time;
import br.com.persistenciafa7.util.HibernateUtil;

public class MudancaDeTecnico {
	
	
	public static void main(String[] args) {
		Session s = HibernateUtil.getHibernateSession();
		s.getTransaction().begin();
		contratarNovoTecnico("Fortaleza", "Ceará");
		s.getTransaction().commit();
	}
	
	
	/**
	 * Desvincula o técnico atual dos times passados por parâmetro e insere um novo técnico
	 * 
	 * @author erinaldo.souza
	 * @since 2016-03-22
	 * 
	 * @param nomeTime
	 */
	public static void contratarNovoTecnico(String... nomeTime) {
		TimeDao td = new TimeDao();		
		Time time = null;
		
		for (String nome : nomeTime) {
			time = td.findByName(nome);
			Collection<Pessoa> pessoas = time.getPessoas();
			Iterator<Pessoa> ite = pessoas.iterator();
			
			while (ite.hasNext()) {
				Pessoa pessoa = ite.next();
				if(pessoa instanceof Tecnico) {
					pessoa.setNome("EX" + pessoa.getNome().replaceAll("NOVO", ""));
					pessoa.setTime(null);
					break;
				}
			}
				
			time.getPessoas().add(new Tecnico("Novo Tecnico do " + time.getNome(), "Times de 2º Divisão", time));
			td.saveOrUpdate(time);
		}
	}
}