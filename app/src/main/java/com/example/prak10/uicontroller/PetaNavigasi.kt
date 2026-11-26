package com.example.prak10.uicontroller

@Composable
fun DataSiswaApp(navController: NavHostController =
                     rememberNavController(), modifier: Modifier){
    HostNavigasi(navController = navController)
}

@Composable
fun HostNavigasi(
    navController: NavHostController,
    modifier: Modifier = Modifier
){
   