��U S E   [ m a s t e r ]  
 G O  
 / * * * * * *   O b j e c t :     D a t a b a s e   [ C o n g T y D u L i c h ]         S c r i p t   D a t e :   4 / 3 / 2 0 2 3   1 0 : 2 4 : 5 2   P M   * * * * * * /  
 C R E A T E   D A T A B A S E   [ C o n g T y D u L i c h ]  
   C O N T A I N M E N T   =   N O N E  
   O N     P R I M A R Y    
 (   N A M E   =   N ' C o n g T y D u L i c h ' ,   F I L E N A M E   =   N ' D : \ C o n g T y D u L i c h . m d f '   ,   S I Z E   =   8 1 9 2 K B   ,   M A X S I Z E   =   U N L I M I T E D ,   F I L E G R O W T H   =   6 5 5 3 6 K B   )  
   L O G   O N    
 (   N A M E   =   N ' C o n g T y D u L i c h _ l o g ' ,   F I L E N A M E   =   N ' D : \ C o n g T y D u L i c h _ l o g . l d f '   ,   S I Z E   =   8 1 9 2 K B   ,   M A X S I Z E   =   2 0 4 8 G B   ,   F I L E G R O W T H   =   6 5 5 3 6 K B   )  
   W I T H   C A T A L O G _ C O L L A T I O N   =   D A T A B A S E _ D E F A U L T  
 G O  
 A L T E R   D A T A B A S E   [ C o n g T y D u L i c h ]   S E T   C O M P A T I B I L I T Y _ L E V E L   =   1 5 0  
 G O  
 I F   ( 1   =   F U L L T E X T S E R V I C E P R O P E R T Y ( ' I s F u l l T e x t I n s t a l l e d ' ) )  
 b e g i n  
 E X E C   [ C o n g T y D u L i c h ] . [ d b o ] . [ s p _ f u l l t e x t _ d a t a b a s e ]   @ a c t i o n   =   ' e n a b l e '  
 e n d  
 G O  
 A L T E R   D A T A B A S E   [ C o n g T y D u L i c h ]   S E T   A N S I _ N U L L _ D E F A U L T   O F F    
 G O  
 A L T E R   D A T A B A S E   [ C o n g T y D u L i c h ]   S E T   A N S I _ N U L L S   O F F    
 G O  
 A L T E R   D A T A B A S E   [ C o n g T y D u L i c h ]   S E T   A N S I _ P A D D I N G   O F F    
 G O  
 A L T E R   D A T A B A S E   [ C o n g T y D u L i c h ]   S E T   A N S I _ W A R N I N G S   O F F    
 G O  
 A L T E R   D A T A B A S E   [ C o n g T y D u L i c h ]   S E T   A R I T H A B O R T   O F F    
 G O  
 A L T E R   D A T A B A S E   [ C o n g T y D u L i c h ]   S E T   A U T O _ C L O S E   O F F    
 G O  
 A L T E R   D A T A B A S E   [ C o n g T y D u L i c h ]   S E T   A U T O _ S H R I N K   O F F    
 G O  
 A L T E R   D A T A B A S E   [ C o n g T y D u L i c h ]   S E T   A U T O _ U P D A T E _ S T A T I S T I C S   O N    
 G O  
 A L T E R   D A T A B A S E   [ C o n g T y D u L i c h ]   S E T   C U R S O R _ C L O S E _ O N _ C O M M I T   O F F    
 G O  
 A L T E R   D A T A B A S E   [ C o n g T y D u L i c h ]   S E T   C U R S O R _ D E F A U L T     G L O B A L    
 G O  
 A L T E R   D A T A B A S E   [ C o n g T y D u L i c h ]   S E T   C O N C A T _ N U L L _ Y I E L D S _ N U L L   O F F    
 G O  
 A L T E R   D A T A B A S E   [ C o n g T y D u L i c h ]   S E T   N U M E R I C _ R O U N D A B O R T   O F F    
 G O  
 A L T E R   D A T A B A S E   [ C o n g T y D u L i c h ]   S E T   Q U O T E D _ I D E N T I F I E R   O F F    
 G O  
 A L T E R   D A T A B A S E   [ C o n g T y D u L i c h ]   S E T   R E C U R S I V E _ T R I G G E R S   O F F    
 G O  
 A L T E R   D A T A B A S E   [ C o n g T y D u L i c h ]   S E T     D I S A B L E _ B R O K E R    
 G O  
 A L T E R   D A T A B A S E   [ C o n g T y D u L i c h ]   S E T   A U T O _ U P D A T E _ S T A T I S T I C S _ A S Y N C   O F F    
 G O  
 A L T E R   D A T A B A S E   [ C o n g T y D u L i c h ]   S E T   D A T E _ C O R R E L A T I O N _ O P T I M I Z A T I O N   O F F    
 G O  
 A L T E R   D A T A B A S E   [ C o n g T y D u L i c h ]   S E T   T R U S T W O R T H Y   O F F    
 G O  
 A L T E R   D A T A B A S E   [ C o n g T y D u L i c h ]   S E T   A L L O W _ S N A P S H O T _ I S O L A T I O N   O F F    
 G O  
 A L T E R   D A T A B A S E   [ C o n g T y D u L i c h ]   S E T   P A R A M E T E R I Z A T I O N   S I M P L E    
 G O  
 A L T E R   D A T A B A S E   [ C o n g T y D u L i c h ]   S E T   R E A D _ C O M M I T T E D _ S N A P S H O T   O F F    
 G O  
 A L T E R   D A T A B A S E   [ C o n g T y D u L i c h ]   S E T   H O N O R _ B R O K E R _ P R I O R I T Y   O F F    
 G O  
 A L T E R   D A T A B A S E   [ C o n g T y D u L i c h ]   S E T   R E C O V E R Y   S I M P L E    
 G O  
 A L T E R   D A T A B A S E   [ C o n g T y D u L i c h ]   S E T     M U L T I _ U S E R    
 G O  
 A L T E R   D A T A B A S E   [ C o n g T y D u L i c h ]   S E T   P A G E _ V E R I F Y   C H E C K S U M      
 G O  
 A L T E R   D A T A B A S E   [ C o n g T y D u L i c h ]   S E T   D B _ C H A I N I N G   O F F    
 G O  
 A L T E R   D A T A B A S E   [ C o n g T y D u L i c h ]   S E T   F I L E S T R E A M (   N O N _ T R A N S A C T E D _ A C C E S S   =   O F F   )    
 G O  
 A L T E R   D A T A B A S E   [ C o n g T y D u L i c h ]   S E T   T A R G E T _ R E C O V E R Y _ T I M E   =   6 0   S E C O N D S    
 G O  
 A L T E R   D A T A B A S E   [ C o n g T y D u L i c h ]   S E T   D E L A Y E D _ D U R A B I L I T Y   =   D I S A B L E D    
 G O  
 A L T E R   D A T A B A S E   [ C o n g T y D u L i c h ]   S E T   A C C E L E R A T E D _ D A T A B A S E _ R E C O V E R Y   =   O F F      
 G O  
 A L T E R   D A T A B A S E   [ C o n g T y D u L i c h ]   S E T   Q U E R Y _ S T O R E   =   O F F  
 G O  
 U S E   [ C o n g T y D u L i c h ]  
 G O  
 / * * * * * *   O b j e c t :     T a b l e   [ d b o ] . [ D i a D i e m ]         S c r i p t   D a t e :   4 / 3 / 2 0 2 3   1 0 : 2 4 : 5 2   P M   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O N  
 G O  
 C R E A T E   T A B L E   [ d b o ] . [ D i a D i e m ] (  
 	 [ M a D i a D i e m ]   [ n v a r c h a r ] ( 2 0 )   N O T   N U L L ,  
 	 [ T e n D i a D i e m ]   [ n v a r c h a r ] ( 1 0 0 )   N O T   N U L L ,  
   C O N S T R A I N T   [ P K _ D i a D i e m ]   P R I M A R Y   K E Y   C L U S T E R E D    
 (  
 	 [ M a D i a D i e m ]   A S C  
 ) W I T H   ( P A D _ I N D E X   =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E   =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   A L L O W _ R O W _ L O C K S   =   O N ,   A L L O W _ P A G E _ L O C K S   =   O N ,   O P T I M I Z E _ F O R _ S E Q U E N T I A L _ K E Y   =   O F F )   O N   [ P R I M A R Y ]  
 )   O N   [ P R I M A R Y ]  
 G O  
 / * * * * * *   O b j e c t :     T a b l e   [ d b o ] . [ H o a D o n ]         S c r i p t   D a t e :   4 / 3 / 2 0 2 3   1 0 : 2 4 : 5 2   P M   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O N  
 G O  
 C R E A T E   T A B L E   [ d b o ] . [ H o a D o n ] (  
 	 [ S o H o a D o n ]   [ n v a r c h a r ] ( 2 0 )   N O T   N U L L ,  
 	 [ M a K H ]   [ n v a r c h a r ] ( 2 0 )   N O T   N U L L ,  
 	 [ M a T o u r ]   [ n v a r c h a r ] ( 2 0 )   N O T   N U L L ,  
 	 [ N g a y L a p H D ]   [ d a t e t i m e ]   N U L L ,  
   C O N S T R A I N T   [ P K _ H o a D o n ]   P R I M A R Y   K E Y   C L U S T E R E D    
 (  
 	 [ S o H o a D o n ]   A S C  
 ) W I T H   ( P A D _ I N D E X   =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E   =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   A L L O W _ R O W _ L O C K S   =   O N ,   A L L O W _ P A G E _ L O C K S   =   O N ,   O P T I M I Z E _ F O R _ S E Q U E N T I A L _ K E Y   =   O F F )   O N   [ P R I M A R Y ]  
 )   O N   [ P R I M A R Y ]  
 G O  
 / * * * * * *   O b j e c t :     T a b l e   [ d b o ] . [ K h a c h H a n g ]         S c r i p t   D a t e :   4 / 3 / 2 0 2 3   1 0 : 2 4 : 5 2   P M   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O N  
 G O  
 C R E A T E   T A B L E   [ d b o ] . [ K h a c h H a n g ] (  
 	 [ M a K H ]   [ n v a r c h a r ] ( 2 0 )   N O T   N U L L ,  
 	 [ S D T ]   [ n v a r c h a r ] ( 1 1 )   N O T   N U L L ,  
 	 [ M a t K h a u ]   [ n v a r c h a r ] ( 5 0 )   N O T   N U L L ,  
 	 [ T e n K H ]   [ n v a r c h a r ] ( 5 0 )   N O T   N U L L ,  
 	 [ N g a y S i n h ]   [ d a t e ]   N U L L ,  
 	 [ G i o i T i n h ]   [ b i t ]   N U L L ,  
 	 [ E m a i l ]   [ n v a r c h a r ] ( 5 0 )   N U L L ,  
 	 [ D i a C h i ]   [ n v a r c h a r ] ( 5 0 )   N U L L ,  
   C O N S T R A I N T   [ P K _ K h a c h H a n g ]   P R I M A R Y   K E Y   C L U S T E R E D    
 (  
 	 [ M a K H ]   A S C  
 ) W I T H   ( P A D _ I N D E X   =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E   =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   A L L O W _ R O W _ L O C K S   =   O N ,   A L L O W _ P A G E _ L O C K S   =   O N ,   O P T I M I Z E _ F O R _ S E Q U E N T I A L _ K E Y   =   O F F )   O N   [ P R I M A R Y ]  
 )   O N   [ P R I M A R Y ]  
 G O  
 / * * * * * *   O b j e c t :     T a b l e   [ d b o ] . [ N h a n V i e n ]         S c r i p t   D a t e :   4 / 3 / 2 0 2 3   1 0 : 2 4 : 5 2   P M   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O N  
 G O  
 C R E A T E   T A B L E   [ d b o ] . [ N h a n V i e n ] (  
 	 [ M a N V ]   [ n v a r c h a r ] ( 2 0 )   N O T   N U L L ,  
 	 [ S D T ]   [ n v a r c h a r ] ( 1 1 )   N O T   N U L L ,  
 	 [ M a t K h a u ]   [ n v a r c h a r ] ( 5 0 )   N O T   N U L L ,  
 	 [ T e n N V ]   [ n v a r c h a r ] ( 5 0 )   N O T   N U L L ,  
 	 [ N g a y S i n h ]   [ d a t e ]   N U L L ,  
 	 [ G i o i T i n h ]   [ b i t ]   N U L L ,  
 	 [ C C C D ]   [ n v a r c h a r ] ( 1 2 )   N U L L ,  
 	 [ N g a y V a o L a m ]   [ d a t e ]   N U L L ,  
   C O N S T R A I N T   [ P K _ N h a n V i e n ]   P R I M A R Y   K E Y   C L U S T E R E D    
 (  
 	 [ M a N V ]   A S C  
 ) W I T H   ( P A D _ I N D E X   =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E   =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   A L L O W _ R O W _ L O C K S   =   O N ,   A L L O W _ P A G E _ L O C K S   =   O N ,   O P T I M I Z E _ F O R _ S E Q U E N T I A L _ K E Y   =   O F F )   O N   [ P R I M A R Y ]  
 )   O N   [ P R I M A R Y ]  
 G O  
 / * * * * * *   O b j e c t :     T a b l e   [ d b o ] . [ T o u r D u L i c h ]         S c r i p t   D a t e :   4 / 3 / 2 0 2 3   1 0 : 2 4 : 5 2   P M   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O N  
 G O  
 C R E A T E   T A B L E   [ d b o ] . [ T o u r D u L i c h ] (  
 	 [ M a T o u r ]   [ n v a r c h a r ] ( 2 0 )   N O T   N U L L ,  
 	 [ T e n T o u r ]   [ n v a r c h a r ] ( 1 0 0 )   N O T   N U L L ,  
 	 [ M o T a ]   [ n v a r c h a r ] ( 1 0 0 0 )   N U L L ,  
 	 [ S o C h o ]   [ i n t ]   N O T   N U L L ,  
 	 [ P h u o n g T i e n ]   [ n v a r c h a r ] ( 5 0 )   N U L L ,  
 	 [ N g a y D i ]   [ d a t e ]   N O T   N U L L ,  
 	 [ N g a y K e t T h u c ]   [ d a t e ]   N O T   N U L L ,  
 	 [ D i e m K H ]   [ n v a r c h a r ] ( 2 0 )   N O T   N U L L ,  
 	 [ D i e m K T ]   [ n v a r c h a r ] ( 2 0 )   N O T   N U L L ,  
 	 [ K h a c h S a n ]   [ n v a r c h a r ] ( 5 0 )   N U L L ,  
 	 [ G i a ]   [ d e c i m a l ] ( 1 8 ,   2 )   N U L L ,  
 	 [ A n h ]   [ n v a r c h a r ] ( 2 0 0 )   N U L L ,  
   C O N S T R A I N T   [ P K _ T o u r D u L i c h ]   P R I M A R Y   K E Y   C L U S T E R E D    
 (  
 	 [ M a T o u r ]   A S C  
 ) W I T H   ( P A D _ I N D E X   =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E   =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   A L L O W _ R O W _ L O C K S   =   O N ,   A L L O W _ P A G E _ L O C K S   =   O N ,   O P T I M I Z E _ F O R _ S E Q U E N T I A L _ K E Y   =   O F F )   O N   [ P R I M A R Y ]  
 )   O N   [ P R I M A R Y ]  
 G O  
 / * * * * * *   O b j e c t :     T a b l e   [ d b o ] . [ T h a n h V i e n ]         S c r i p t   D a t e :   4 / 3 / 2 0 2 3   1 0 : 2 4 : 5 2   P M   * * * * * * /  
 S E T   A N S I _ N U L L S   O N  
 G O  
 S E T   Q U O T E D _ I D E N T I F I E R   O N  
 G O  
 C R E A T E   T A B L E   [ d b o ] . [ T h a n h V i e n ] (  
 	 [ M a T V ]   [ n v a r c h a r ] ( 2 0 )   N O T   N U L L ,  
 	 [ M a H D ]   [ n v a r c h a r ] ( 2 0 )   N O T   N U L L ,  
 	 [ T e n T V ]   [ n v a r c h a r ] ( 5 0 )   N O T   N U L L ,  
 	 [ G i o i T i n h ]   [ b i t ]   N U L L ,  
 	 [ N g a y S i n h ]   [ d a t e ]   N U L L ,  
 	 [ L u a T u o i ]   [ b i t ]   N U L L ,  
   C O N S T R A I N T   [ P K _ T h a n h V i e n ]   P R I M A R Y   K E Y   C L U S T E R E D    
 (  
 	 [ M a T V ]   A S C  
 ) W I T H   ( P A D _ I N D E X   =   O F F ,   S T A T I S T I C S _ N O R E C O M P U T E   =   O F F ,   I G N O R E _ D U P _ K E Y   =   O F F ,   A L L O W _ R O W _ L O C K S   =   O N ,   A L L O W _ P A G E _ L O C K S   =   O N ,   O P T I M I Z E _ F O R _ S E Q U E N T I A L _ K E Y   =   O F F )   O N   [ P R I M A R Y ]  
 )   O N   [ P R I M A R Y ]  
 G O  
 A L T E R   T A B L E   [ d b o ] . [ H o a D o n ]     W I T H   C H E C K   A D D   F O R E I G N   K E Y ( [ M a K H ] )  
 R E F E R E N C E S   [ d b o ] . [ K h a c h H a n g ]   ( [ M a K H ] )  
 G O  
 A L T E R   T A B L E   [ d b o ] . [ H o a D o n ]     W I T H   C H E C K   A D D   F O R E I G N   K E Y ( [ M a T o u r ] )  
 R E F E R E N C E S   [ d b o ] . [ T o u r D u L i c h ]   ( [ M a T o u r ] )  
 G O  
 A L T E R   T A B L E   [ d b o ] . [ T o u r D u L i c h ]     W I T H   C H E C K   A D D   F O R E I G N   K E Y ( [ D i e m K H ] )  
 R E F E R E N C E S   [ d b o ] . [ D i a D i e m ]   ( [ M a D i a D i e m ] )  
 G O  
 A L T E R   T A B L E   [ d b o ] . [ T o u r D u L i c h ]     W I T H   C H E C K   A D D   F O R E I G N   K E Y ( [ D i e m K T ] )  
 R E F E R E N C E S   [ d b o ] . [ D i a D i e m ]   ( [ M a D i a D i e m ] )  
 G O  
 A L T E R   T A B L E   [ d b o ] . [ T h a n h V i e n ]     W I T H   C H E C K   A D D   F O R E I G N   K E Y ( [ M a H D ] )  
 R E F E R E N C E S   [ d b o ] . [ H o a D o n ]   ( [ S o H o a D o n ] )  
 G O  
 U S E   [ m a s t e r ]  
 G O  
 A L T E R   D A T A B A S E   [ C o n g T y D u L i c h ]   S E T     R E A D _ W R I T E    
 G O  
 