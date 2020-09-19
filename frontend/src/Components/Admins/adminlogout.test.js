import React from 'react';
import ReactDOM from 'react-dom';
import { mount,configure } from 'enzyme';
import { MemoryRouter } from 'react-router';
import NavigationBarAdminPage from '../Layout/NagivationBarAdminPage';
import App from '../../App';
import Adapter from 'enzyme-adapter-react-16';

configure({ adapter: new Adapter() });

test('valid path for worker page', () => {
    const wrapper = mount(
      <MemoryRouter initialEntries={[ '/admin/login' ]}>
        <App/>
      </MemoryRouter>
    );
    expect(wrapper.find(<NavigationBarAdminPage/>)).toHaveLength(0);
  });