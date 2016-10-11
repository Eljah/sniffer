package ru.itis.dao;

import ru.itis.pojo.SniffResult;

import java.util.Date;
import java.util.List;

/**
 * Created by Ilya Evlampiev on 02.11.2015.
 */
public interface SniffResultDao {
    /**
     * Создает новую запись и соответствующий ей объект
     */
    public void create(SniffResult sniffResult);


    public SniffResult readSniffResult(SniffResult sniffResult);

    public List<SniffResult> readAllSniffResults();


    /**
     * Удаляет запись об объекте из базы данных
     */
    public void deleteSniffResult(SniffResult sniffResult);

    public void deleteSniffResultBefore(Date date);

    public void deleteSniffResultForReferer(String referrer);

}
