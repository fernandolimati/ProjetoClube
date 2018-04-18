# ProjetoClube

Projeto CLube foi desenvolvido na faculdade pelo professor de modelagem de banco de dados, para treino pessoal eu tive que criar esse 
projeto paralelo aonde eu consumo o servico do banco por um servico RESTFULL criado por mim em outro projeto usando autenticação JWT
(Json Token). Na versao ate o dia 23/03/2018 ele faz autenticacao e pega o token a cada instancia do objeto, porem a ideia e virar uma
classe Singleton aonde a mesma so renova o token caso o mesmo tenha expirado, a regra do negocio do servico é ate o momento 24hrs, podendo
mudar. Lembrando que e um projeto educacional e apenas de aprendizado pessoal e paralelo.
