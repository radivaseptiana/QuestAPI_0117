package com.example.prak10.view

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    //edit 1.1 : tambahkan parameter navigateToItemEntry
    navigateToItemEntry: () -> Unit,

    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(factory =
        PenyediaViewModel.Factory)
) {
    val scrollBehavior = TopAppBarDefaults
        .exitUntilCollapsedScrollBehavior()
    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior
            .nestedScrollConnection),
        topBar = {
            SiswaTopAppBar(
                title = stringResource(DestinasiHome.titleRes),
                canNavigateBack = false,
                scrollBehavior = scrollBehavior
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                //edit 1.2 : event onClick
                onClick = navigateToItemEntry,
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier.padding(dimensionResource(id =
                    R.dimen.padding_large))
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = stringResource(R.string
                        .entry_siswa)
                )
            }
        },
    ) { innerPadding ->
        HomeBody(
            statusUiSiswa = viewModel.listSiswa,
            retryAction = viewModel::loadSiswa,
            modifier = modifier
                .padding(innerPadding)
                .fillMaxSize()
        )
    }
}
