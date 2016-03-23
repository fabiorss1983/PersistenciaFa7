package br.com.persistenciafa7.main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import br.com.persistenciafa7.model.Campeonato;
import br.com.persistenciafa7.model.Cidade;
import br.com.persistenciafa7.model.Conquista;
import br.com.persistenciafa7.model.Estadio;
import br.com.persistenciafa7.model.Estado;
import br.com.persistenciafa7.model.Jogador;
import br.com.persistenciafa7.model.Partida;
import br.com.persistenciafa7.model.Pessoa;
import br.com.persistenciafa7.model.Tecnico;
import br.com.persistenciafa7.model.Time;
import br.com.persistenciafa7.util.HibernateUtil;

public class DBLoad {

	private static Session session;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		session = HibernateUtil.getHibernateSession();
		session.beginTransaction();

		Estado ce = new Estado("Ceará", "CE");
		session.save(ce);

		Estado pe = new Estado("Pernambuco", "PE");
		session.save(pe);

		Cidade fortaleza = new Cidade("Fortaleza", ce);
		session.save(fortaleza);

		Cidade horizonte = new Cidade("Horizonte", ce);
		session.save(horizonte);

		Cidade sobral = new Cidade("Sobral", ce);
		session.save(sobral);

		Cidade recife = new Cidade("Recife", pe);
		session.save(recife);

		Estadio castelao = new Estadio("Castelão", 60000, fortaleza);
		session.save(castelao);

		Estadio pv = new Estadio("Pres. Vargas", 20000, fortaleza);
		session.save(pv);

		Estadio junco = new Estadio("Junco", 15000, sobral);
		session.save(junco);

		Estadio ilha = new Estadio("Ilha do retiro", 30000, recife);
		session.save(ilha);

		Time csc = new Time("Ceará", fortaleza, castelao);
		session.save(csc);

		Time fec = new Time("Fortaleza", fortaleza, pv);
		session.save(fec);

		Time hfc = new Time("Horizonte", horizonte, pv);
		session.save(hfc);

		Time gsc = new Time("Guarani", sobral, junco);
		session.save(gsc);

		Collection<Time> times = session.createCriteria(Time.class).list();
		inserePessoasNosTimes(times);

		Campeonato brasileiro = new Campeonato("Brasileiro", 800000);
		session.save(brasileiro);

		Campeonato copaBrasil = new Campeonato("Copa do Brasil", 500000);
		session.save(copaBrasil);

		Campeonato copaNordeste = new Campeonato("Copa do Nordeste", 200000);
		session.save(copaNordeste);

		Campeonato cearense = new Campeonato("Campeonato Cearense", 100000);
		session.save(cearense);

		Conquista conqNOR = new Conquista();
		conqNOR.setCampeonato(copaNordeste);
		conqNOR.setTime(csc);
		conqNOR.setQuantidade(1);
		session.save(conqNOR);

		Conquista conqCSC = new Conquista();
		conqCSC.setCampeonato(cearense);
		conqCSC.setTime(csc);
		conqCSC.setQuantidade(43);
		session.save(conqCSC);

		Conquista conqFEC = new Conquista();
		conqFEC.setCampeonato(cearense);
		conqFEC.setTime(fec);
		conqFEC.setQuantidade(40);
		session.save(conqFEC);

		Partida partida1 = new Partida();
		partida1.setData(new Date());
		partida1.setMandante(csc);
		partida1.setVisitante(hfc);
		session.save(partida1);

		Partida partida2 = new Partida();
		partida2.setData(new Date());
		partida2.setMandante(fec);
		partida2.setVisitante(gsc);
		session.save(partida2);

		Partida partida3 = new Partida();
		partida3.setData(new Date());
		partida3.setMandante(csc);
		partida3.setVisitante(fec);
		session.save(partida3);
		
		session.getTransaction().commit();
	}

	/**
	 * Insere os jogadores, tecnicos e pessoas comuns associadas a um time
	 * 
	 * @author erinaldo.souza
	 * @since 2016-03-18
	 * 
	 * @param times
	 */
	private static void inserePessoasNosTimes(Collection<Time> times) {
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		Pessoa p = null;

		Map<Integer, String> posicoes = new HashMap<Integer, String>();
		posicoes.put(1, "Goleiro");
		posicoes.put(2, "Lateral");
		posicoes.put(3, "Zagueiro");
		posicoes.put(4, "Zagueiro");
		posicoes.put(5, "Volante");
		posicoes.put(6, "Lateral");
		posicoes.put(7, "Meio-campo");
		posicoes.put(8, "Volante");
		posicoes.put(9, "Atacante");
		posicoes.put(10, "Meio-campo");
		posicoes.put(11, "Atacante");
		posicoes.put(12, "Goleiro");
		posicoes.put(13, "Lateral");
		posicoes.put(14, "Zagueiro");
		posicoes.put(15, "Zagueiro");
		posicoes.put(16, "Volante");
		posicoes.put(17, "Lateral");
		posicoes.put(18, "Meio-campo");
		posicoes.put(19, "Volante");
		posicoes.put(20, "Atacante");
		posicoes.put(21, "Meio-campo");
		posicoes.put(22, "Atacante");
		posicoes.put(23, "Goleiro");

		for (Time time : times) {
			for (int i = 1; i <= posicoes.size(); i++) {
				p = new Jogador("jogador_" + i + "_" + time.getNome(), posicoes.get(i), time);
				session.save(p);
				pessoas.add(p);
			}

			p = new Tecnico("Tecnico do " + time.getNome(), "Tecnico", time);
			session.save(p);
			pessoas.add(p);

			p = new Tecnico("Medico do " + time.getNome(), "Medico", time);
			session.save(p);
			pessoas.add(p);

			p = new Tecnico("Preparador fisico do " + time.getNome(), "Educacao fisica", time);
			session.save(p);
			pessoas.add(p);

			p = new Tecnico("Fisioterapeuta do " + time.getNome(), "Educacao fisica", time);
			session.save(p);
			pessoas.add(p);

			p = new Pessoa("Torcedor do " + time.getNome(), time);
			session.save(p);

			time.setPessoas(pessoas);
			session.saveOrUpdate(time);
			pessoas.clear();
		}
	}
}
