# IMDb crawler
___
Este projeto tem como objetivo buscar os 10 piores filmes existentes no conjunto de dados [IMDb](https://www.imdb.com/chart/bottom) e 
retornar as seguintes características de cada filme:

        - Título do filme;
        - Nota média de avaliaçãoo do filme;
        - Elenco do filme;
        - Diretor(es) do filme;
        - Pelo menos um comentário positivo do filme contendo:
            - título do comentário;
            - autor do comentário; 
            - nota de avaliação;
            - comentário em si.

Foi utilizada a biblioteca [JSoup](https://jsoup.org) para facilitar a varredura da página do IMDb,
recuperar as informações necessárias e por fim realizar a impressão dos dados ao fim de toda a captura.