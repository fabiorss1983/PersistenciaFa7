package br.com.persistenciafa7.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.persistenciafa7.model.BaseModel;
import br.com.persistenciafa7.util.HibernateUtil;

public class GenericDao {
	
	protected final Session session;

    public GenericDao() {
    	this.session = HibernateUtil.getHibernateSession();
    }
    
    protected void begin() {
    	session.getTransaction().begin();
    }
    
    protected void commit() {
    	session.getTransaction().commit();
    }
    
    protected void rollback() {
    	session.getTransaction().rollback();
    }
    
    /**
     * Salva o objeto passado por parâmetro
     * 
     * @author erinaldo.souza
     * @since 2016-03-18
     * 
     * @param bm
     */
    public void salvar(BaseModel bm){
    	session.saveOrUpdate(bm);
    }
    
    
    /**
     * Remove o objeto passaro por parâmetro
     * 
     *  @author erinaldo.souza
     *  @since 2016-03-18
     *  
     *  @param bm
     */
    public void deletar(BaseModel bm){
    	session.delete(bm);
    }
    
    /**
     * Lista os registros de uma determinada tabela
     * 
     * @author erinaldo.souza
     * @since 2016-03-18
     * 
     * @return lista de registros da tabela especificada pelo parâmetro bm
     * 
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<BaseModel> listarTodos(Class bm){
    	return session.createQuery("from "+bm.getName()+" e where e.isAtivo = true").list();
    }
    
    /**
     * Busca o objeto passado por parâmetro
     * 
     * @author erinaldo.souza
     * @since 2016-03-18
     * 
     * @param bm
     * @return objeto gerenciado pelo hibernate
     */
    public BaseModel find(BaseModel bm) {
    	return (BaseModel) session.get(bm.getClass(), bm);
    }
}