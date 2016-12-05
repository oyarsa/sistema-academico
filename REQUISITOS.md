# DESCRIÇÃO DO SISTEMA

O sistema de controle de projetos deverá armazenar os projetos para que o coordenador possa acompanhá-los. Para
isso, ele precisa armazenar dados de todos os projetos, relacionando as pessoas atuantes em cada projeto e a
quantidade de horas que cada pessoa trabalhou em cada projeto.

Futuramente, as horas de entrada e saída serão computadas via impressão digital, entretanto, no momento, essa
entrada de horários será feita pelo próprio usuário, no momento em que este inicia um determinado trabalho ou tarefa
do projeto ao qual esteja alocado.

O responsável de cada projeto fará um cadastro de atividades e a partir deste cadastro inicial, os usuários alocados para
trabalhar no projeto informarão a hora de início e a atividade que passarão a realizar. Ao final da tarefa, o usuário deverá
informar a hora de término e qualquer outra observação que julgar necessária, relacionando com o respectivo projeto,
em campo descritivo. Caso a atividade não esteja concluída ao final do turno, o usuário deve informar a hora de parada
sem informar o final da atividade.

Deve existir um cadastro para o tipo de trabalho realizado, seja ele de manutenção, de implementação, de alteração ou
criação, de modelagem, ou outro tipo qualquer pertinente ao projeto. Cada usuário pode estar associado a mais de um
projeto. Sendo assim, um determinado usuário pode realizar diferentes atividades em projetos distintos em um mesmo
dia, sendo necessária a divisão do seu tempo para cada atividade. Nestes casos, é importante que o usuário seja capaz
de relacionar cada atividade ao seu projeto de origem além de informar início e fim de cada atividade. Vale lembrar que
as atividades devem ser sempre bem definidas, e isto é papel do usuário responsável.

O sistema deverá permitir o cadastro de usuários, que são as pessoas que trabalham nos projetos e que cadastrarão
suas atividades, com as respectivas horas de trabalho. Por conta disso, todo usuário cadastrado tem um perfil, seja ele
administrador, coordenador de projeto ou recurso de projeto. A visão do usuário varia conforme seu perfil. Caso seja
administrador, poderá ter acesso a todas as atividades de todos os usuários ativos no sistema, além de poder cadastrar
usuários. A visão do coordenador permite visualizar horas e descrições dos recursos, além de relatórios específicos para
seu controle como o de horas trabalhadas em determinado projeto por período, horas por recurso, horas por projeto,
dias trabalhados, entre outros.

Cada usuário cadastrado no sistema deve estar vinculado a períodos nos quais o mesmo será considerado como usuário
ativo, pois como trata-se de um sistema para controle de atividades desempenhadas em Laboratório Acadêmico, as
pessoas terão períodos alternados de vinculação (atividade) e não vinculação (férias, sem atividades, término de um
estágio, etc). No entanto, o seu cadastro não poderá ser iperdido bem como as suas horas trabalhadas nos projetos
deverão ser mantidas. Estes são dados importantes para a emissão de relatórios futuros referentes ao controle de horas
atividades desempenhadas nas dependências do laboratório.

Os usuários do sistema deverão estar separados em categorias referentes a sua vinculação com o Laboratório, quais
sejam: Professor responsável (administrador), Professor colaborador (coordenador - orientador), estagiário do
laboratório (colaborador - trabalha nos projetos e realiza manutenções no laboratório), estagiário supervisionado
(colaborador - trabalha nos projetos), estagiário voluntário (colaborador - trabalha nos projetos).
Os dados pessoais do usuário, quando recurso, incluem nome, RG, CPF, telefones de contato (residencial, celular,
recado), e-mail, nome do pai e da mãe, se é acadêmico ou não. Caso seja acadêmico registra-se também seu RA, período
e curso.

Para entrar no sistema, seja para cadastro de atividade ou acompanhamento, o usuário deverá seguir os seguintes
passos: (i) realizar login, digitando login e senha; (ii) submeter; (iii) aguardar que o sistema verifique a validação do login
e senha; (iv) caso login seja validado, o sistema carregará conforme perfil de usuário; (v) caso contrário, o sistema
comunica ao usuário sobre o erro ao digitar login ou senha (avisar se foi o login ou a senha).

Para cadastro de projetos, o usuário deve ter permissão, o que está vinculado às contas de administrador e coordenador,
e às contas de colaboradores liberadas por um administrador ou coordenador. O cadastro de projetos deve conter o
nome do projeto, o seu objetivo, uma lista com os recursos do laboratório necessários (pode ser um campo de texto),
uma lista com os colaboradores associados ao mesmo, uma lista com as atividades a serem desempenhadas no projeto.

Para o cadastro de colaboradores, o usuário deve ser administrador ou coordenador.

Para o cadastro de atividades, o usuário deve estar vinculado ao projeto ou ser administrador ou coordenador.
As atividades dos projetos devem possuir a possibilidade de se indicar uma dependência, ou seja, não poderá ser iniciada
antes de uma outra atividade ter sido finalizada, para que não se possa eliminar etapas no andamento dos projetos.